package github.mundotv789123.raspadmin.services.stream;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import github.mundotv789123.raspadmin.services.exceptions.InvalidOperateServiceException;

@Component
public class RangeConverterService {

    @Value("${application.storange.range.length:10485760}")
    private long maxLength;

    public long[] getRangeByHeader(String range, long length) throws IndexOutOfBoundsException {
        Pattern pattern = Pattern.compile("bytes ?= ?(\\d{1,18})-(\\d{0,18})");
        Matcher matcher = pattern.matcher(range);

        if (!matcher.find()) {
            throw new InvalidOperateServiceException("Header Range inválido", HttpStatus.REQUESTED_RANGE_NOT_SATISFIABLE);
        }

        long start = matcher.group(1).isEmpty() ? 0 : Long.parseLong(matcher.group(1));
        long end = matcher.group(2).isEmpty() ? 0 : Long.parseLong(matcher.group(2));

        if (end <= 0)
            end = start + maxLength;

        if (start > end) {
            start = 0;
            end = maxLength;
        }

        if (end > (length - 1))
            end = length - 1;

        if (end - start > maxLength || end == 0)
            end = start + maxLength;

        if ((end - start) > maxLength) {
            throw new InvalidOperateServiceException("Header Range inválido", HttpStatus.REQUESTED_RANGE_NOT_SATISFIABLE);
        }

        return new long[] { start, end };
    }
}
