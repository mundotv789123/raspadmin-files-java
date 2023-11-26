(self.webpackChunk_N_E=self.webpackChunk_N_E||[]).push([[857],{8857:function(e,t,r){"use strict";var n=r(3322),o=r(6089),a=r(5667),u=r(1961),i=r(7731);function _createSuper(e){var t=_isNativeReflectConstruct();return function(){var r,n=i(e);if(t){var o=i(this).constructor;r=Reflect.construct(n,arguments,o)}else r=n.apply(this,arguments);return u(this,r)}}function _isNativeReflectConstruct(){if("undefined"==typeof Reflect||!Reflect.construct||Reflect.construct.sham)return!1;if("function"==typeof Proxy)return!0;try{return Boolean.prototype.valueOf.call(Reflect.construct(Boolean,[],function(){})),!0}catch(e){return!1}}Object.defineProperty(t,"__esModule",{value:!0}),Object.defineProperty(t,"default",{enumerable:!0,get:function(){return p}});var c=r(8754),l=c._(r(7294)),d=c._(r(2268)),f={400:"Bad Request",404:"This page could not be found",405:"Method Not Allowed",500:"Internal Server Error"};function _getInitialProps(e){var t=e.res,r=e.err;return{statusCode:t&&t.statusCode?t.statusCode:r?r.statusCode:404}}var s={error:{fontFamily:'system-ui,"Segoe UI",Roboto,Helvetica,Arial,sans-serif,"Apple Color Emoji","Segoe UI Emoji"',height:"100vh",textAlign:"center",display:"flex",flexDirection:"column",alignItems:"center",justifyContent:"center"},desc:{lineHeight:"48px"},h1:{display:"inline-block",margin:"0 20px 0 0",paddingRight:23,fontSize:24,fontWeight:500,verticalAlign:"top"},h2:{fontSize:14,fontWeight:400,lineHeight:"28px"},wrap:{display:"inline-block"}},p=function(e){a(Error,e);var t=_createSuper(Error);function Error(){return n(this,Error),t.apply(this,arguments)}return o(Error,[{key:"render",value:function(){var e=this.props,t=e.statusCode,r=e.withDarkMode,n=this.props.title||f[t]||"An unexpected error has occurred";return l.default.createElement("div",{style:s.error},l.default.createElement(d.default,null,l.default.createElement("title",null,t?t+": "+n:"Application error: a client-side exception has occurred")),l.default.createElement("div",{style:s.desc},l.default.createElement("style",{dangerouslySetInnerHTML:{__html:"body{color:#000;background:#fff;margin:0}.next-error-h1{border-right:1px solid rgba(0,0,0,.3)}"+(void 0===r||r?"@media (prefers-color-scheme:dark){body{color:#fff;background:#000}.next-error-h1{border-right:1px solid rgba(255,255,255,.3)}}":"")}}),t?l.default.createElement("h1",{className:"next-error-h1",style:s.h1},t):null,l.default.createElement("div",{style:s.wrap},l.default.createElement("h2",{style:s.h2},this.props.title||t?n:l.default.createElement(l.default.Fragment,null,"Application error: a client-side exception has occurred (see the browser console for more information)"),"."))))}}]),Error}(l.default.Component);p.displayName="ErrorPage",p.getInitialProps=_getInitialProps,p.origGetInitialProps=_getInitialProps,("function"==typeof t.default||"object"==typeof t.default&&null!==t.default)&&void 0===t.default.__esModule&&(Object.defineProperty(t.default,"__esModule",{value:!0}),Object.assign(t.default,t),e.exports=t.default)},3539:function(e,t,r){"use strict";Object.defineProperty(t,"__esModule",{value:!0}),Object.defineProperty(t,"AmpStateContext",{enumerable:!0,get:function(){return n}});var n=r(8754)._(r(7294)).default.createContext({})},7187:function(e,t){"use strict";function isInAmpMode(e){var t=void 0===e?{}:e,r=t.ampFirst,n=t.hybrid,o=t.hasQuery;return void 0!==r&&r||void 0!==n&&n&&void 0!==o&&o}Object.defineProperty(t,"__esModule",{value:!0}),Object.defineProperty(t,"isInAmpMode",{enumerable:!0,get:function(){return isInAmpMode}})},2268:function(e,t,r){"use strict";var n=r(968);function ownKeys(e,t){var r=Object.keys(e);if(Object.getOwnPropertySymbols){var n=Object.getOwnPropertySymbols(e);t&&(n=n.filter(function(t){return Object.getOwnPropertyDescriptor(e,t).enumerable})),r.push.apply(r,n)}return r}function _objectSpread(e){for(var t=1;t<arguments.length;t++){var r=null!=arguments[t]?arguments[t]:{};t%2?ownKeys(Object(r),!0).forEach(function(t){n(e,t,r[t])}):Object.getOwnPropertyDescriptors?Object.defineProperties(e,Object.getOwnPropertyDescriptors(r)):ownKeys(Object(r)).forEach(function(t){Object.defineProperty(e,t,Object.getOwnPropertyDescriptor(r,t))})}return e}Object.defineProperty(t,"__esModule",{value:!0}),function(e,t){for(var r in t)Object.defineProperty(e,r,{enumerable:!0,get:t[r]})}(t,{defaultHead:function(){return _defaultHead},default:function(){return _default2}});var o=r(8754),a=r(1757)._(r(7294)),u=o._(r(8959)),i=r(3539),c=r(5963),l=r(7187);function _defaultHead(e){void 0===e&&(e=!1);var t=[a.default.createElement("meta",{charSet:"utf-8"})];return e||t.push(a.default.createElement("meta",{name:"viewport",content:"width=device-width"})),t}function onlyReactElement(e,t){return"string"==typeof t||"number"==typeof t?e:t.type===a.default.Fragment?e.concat(a.default.Children.toArray(t.props.children).reduce(function(e,t){return"string"==typeof t||"number"==typeof t?e:e.concat(t)},[])):e.concat(t)}r(9067);var d=["name","httpEquiv","charSet","itemProp"];function unique(){var e=new Set,t=new Set,r=new Set,n={};return function(o){var a=!0,u=!1;if(o.key&&"number"!=typeof o.key&&o.key.indexOf("$")>0){u=!0;var i=o.key.slice(o.key.indexOf("$")+1);e.has(i)?a=!1:e.add(i)}switch(o.type){case"title":case"base":t.has(o.type)?a=!1:t.add(o.type);break;case"meta":for(var c=0,l=d.length;c<l;c++){var f=d[c];if(o.props.hasOwnProperty(f)){if("charSet"===f)r.has(f)?a=!1:r.add(f);else{var s=o.props[f],p=n[f]||new Set;("name"!==f||!u)&&p.has(s)?a=!1:(p.add(s),n[f]=p)}}}}return a}}function reduceComponents(e,t){var r=t.inAmpMode;return e.reduce(onlyReactElement,[]).reverse().concat(_defaultHead(r).reverse()).filter(unique()).reverse().map(function(e,t){var n=e.key||t;if(!r&&"link"===e.type&&e.props.href&&["https://fonts.googleapis.com/css","https://use.typekit.net/"].some(function(t){return e.props.href.startsWith(t)})){var o=_objectSpread({},e.props||{});return o["data-href"]=o.href,o.href=void 0,o["data-optimized-fonts"]=!0,a.default.cloneElement(e,o)}return a.default.cloneElement(e,{key:n})})}var _default2=function(e){var t=e.children,r=(0,a.useContext)(i.AmpStateContext),n=(0,a.useContext)(c.HeadManagerContext);return a.default.createElement(u.default,{reduceComponentsToState:reduceComponents,headManager:n,inAmpMode:(0,l.isInAmpMode)(r)},t)};("function"==typeof t.default||"object"==typeof t.default&&null!==t.default)&&void 0===t.default.__esModule&&(Object.defineProperty(t.default,"__esModule",{value:!0}),Object.assign(t.default,t),e.exports=t.default)},8959:function(e,t,r){"use strict";Object.defineProperty(t,"__esModule",{value:!0}),Object.defineProperty(t,"default",{enumerable:!0,get:function(){return SideEffect}});var n=r(7294),o=n.useLayoutEffect,a=n.useEffect;function SideEffect(e){var t=e.headManager,r=e.reduceComponentsToState;function emitChange(){if(t&&t.mountedInstances){var o=n.Children.toArray(Array.from(t.mountedInstances).filter(Boolean));t.updateHead(r(o,e))}}return o(function(){var r;return null==t||null==(r=t.mountedInstances)||r.add(e.children),function(){var r;null==t||null==(r=t.mountedInstances)||r.delete(e.children)}}),o(function(){return t&&(t._pendingUpdate=emitChange),function(){t&&(t._pendingUpdate=emitChange)}}),a(function(){return t&&t._pendingUpdate&&(t._pendingUpdate(),t._pendingUpdate=null),function(){t&&t._pendingUpdate&&(t._pendingUpdate(),t._pendingUpdate=null)}}),null}},9067:function(e,t){"use strict";Object.defineProperty(t,"__esModule",{value:!0}),Object.defineProperty(t,"warnOnce",{enumerable:!0,get:function(){return warnOnce}});var warnOnce=function(e){}}}]);