(self.webpackChunk_N_E=self.webpackChunk_N_E||[]).push([[405],{572:function(e,n,t){"use strict";t.r(n),t.d(n,{default:function(){return e5}});var i=t(9521),o=t(2640),r=t(5893),a=function(e){if(e.is_dir)return"folder.svg";if(!e.type)return"document.svg";var n=e.type.toString().split("/"),t=(0,o.Z)(n,2),i=t[0],r=t[1];switch(i){case"video":return"video.svg";case"audio":return"music.svg";case"image":return"image.svg";case"application":switch(r){case"java-archive":return"java.svg";case"x-msdos-program":return"exe.svg";case"x-iso9660-image":case"octet-stream":return"iso.svg";case"x-msdownload":case"x-sh":return"document.svg"}return"compact.svg";case"text":if("x-java-source"===r)return"java.svg"}return"document.svg"},s=i.ZP.a.withConfig({displayName:"FileBlock__FileCont",componentId:"sc-180mzed-0"})(["height:130px;margin:5px;text-align:center;overflow:hidden;font-weight:600;word-wrap:break-word;transition:background-color 0.5s;border-radius:5px;&:hover{background:rgba(255,255,255,0.3);overflow:inherit;z-index:1;transition:background-color 0.1s;}"]),c=i.ZP.div.withConfig({displayName:"FileBlock__FileIcon",componentId:"sc-180mzed-1"})(["display:flex;align-items:center;justify-content:center;width:80px;height:80px;margin:5px auto;border-radius:5px;background-size:cover;background-position:center;"]),l=i.ZP.p.withConfig({displayName:"FileBlock__Name",componentId:"sc-180mzed-2"})(["text-align:center;font-weight:bold;"]),d=(0,i.F4)(["0%{transform:rotate(0);}100%{transform:rotate(360deg);}"]),u=i.ZP.div.withConfig({displayName:"FileBlock__Loading",componentId:"sc-180mzed-3"})(["width:32px;height:32px;border-radius:50%;border:solid 5px transparent;border-top:solid 5px cyan;animation:"," 500ms linear infinite;"],d);function p(e){return(0,r.jsxs)(s,{href:e.file.href,children:[(0,r.jsx)(c,{style:{backgroundImage:"url('"+(e.file.icon?e.file.icon:"/img/icons/"+a(e.file))+"')"},children:e.loading&&(0,r.jsx)(u,{})}),(0,r.jsx)(l,{children:e.file.name})]})}var f=(0,i.F4)(["0%{margin-left:0;width:0;}50%{margin-left:0;width:100%;}100%{margin-left:100%;width:0;}"]),g=i.ZP.div.withConfig({displayName:"Loading__LoadingCont",componentId:"sc-4z1qry-0"})(["width:100%;"]),h=i.ZP.div.withConfig({displayName:"Loading__LoadingBar",componentId:"sc-4z1qry-1"})(["height:10px;background-color:white;animation:"," 1s ease infinite;"],f);function m(){return(0,r.jsx)(g,{children:(0,r.jsx)(h,{})})}var x=i.ZP.div.withConfig({displayName:"FilesBlocks__Panel",componentId:"sc-vrga00-0"})(["display:flex;flex-wrap:wrap;flex-direction:row;padding:10px;text-align:center;align-content:start;& a{width:calc(20% - 10px);}@media(min-width:1400px){& a{width:calc(14.2% - 10px);}}@media(max-width:680px){& a{width:calc(50% - 10px);}}"]),v=i.ZP.h1.withConfig({displayName:"FilesBlocks__Text",componentId:"sc-vrga00-1"})(["color:white;text-align:center;width:100%;"]);function y(e){var n,t=e.text;return(null===(n=e.files)||void 0===n?void 0:n.length)==0&&(t="Essa pasta est\xe1 vazia!"),(0,r.jsx)(x,{children:null===e.files?(0,r.jsx)(m,{}):t?(0,r.jsx)(v,{children:t}):e.files.map(function(n,t){return(0,r.jsx)(r.Fragment,{children:(!e.search||n.name.toLowerCase().includes(e.search.toLowerCase()))&&(0,r.jsx)(p,{file:n,loading:e.fileLoading==t},t)})})})}var w=i.ZP.div.withConfig({displayName:"FilesList__Column",componentId:"sc-km3ln0-0"})(["display:flex;flex-direction:column;"]),b=i.ZP.a.withConfig({displayName:"FilesList__FileRow",componentId:"sc-km3ln0-1"})(["padding:12px;font-weight:600;white-space:nowrap;overflow-x:hidden;text-overflow:ellipsis;&:hover{background:rgba(255,255,255,0.3);}"]);function _(e){return e.files?(0,r.jsx)(w,{children:e.files.map(function(e,n){return(0,r.jsx)(b,{href:e.href,children:e.name},n)})}):(0,r.jsx)(w,{})}var k=t(7294),j=t(2777),C=t(2262),P=t(9499),I=t(5121),N=function(){function e(){(0,j.Z)(this,e),(0,P.Z)(this,"API_URL","/api"),this.api=I.Z.create({baseURL:"".concat(this.API_URL,"/auth"),timeout:5e3})}return(0,C.Z)(e,[{key:"login",value:function(e,n,t,i){var o=new URLSearchParams;o.append("username",e),o.append("password",n),this.api.post("/login",o,{auth:{username:e,password:n}}).then(t).catch(function(e){if(i){var n="Erro interno ao processar requisi\xe7\xe3o";try{var t=JSON.parse(e.request.response);t.message&&(n=t.message)}catch(e){}i(n)}})}}]),e}(),S=i.ZP.div.withConfig({displayName:"LoginMenu__LoginCont",componentId:"sc-7cctlv-0"})(["display:flex;position:fixed;top:0;left:0;right:0;bottom:0;z-index:1;background:rgba(9,9,9,1);"]),Z=(0,i.F4)(["0%{opacity:0;transform:translateY(-500px);}90%{opacity:100;transform:translateY(5px);}100%{opacity:100;transform:translateY(0);}"]),L=i.ZP.form.withConfig({displayName:"LoginMenu__LoginForm",componentId:"sc-7cctlv-1"})(["margin:auto;background:rgb(48,48,48);padding:15px 25px;display:block;border-radius:10px;animation:"," 0.8s normal;"],Z),F=i.ZP.h2.withConfig({displayName:"LoginMenu__Title",componentId:"sc-7cctlv-2"})(["text-align:center;margin:15px 0;"]),z=i.ZP.input.withConfig({displayName:"LoginMenu__Input",componentId:"sc-7cctlv-3"})(["display:block;background:rgb(50,50,50);border:solid 1px gray;margin:10px auto;padding:5px;color:white;text-align:center;border-radius:5px;&:focus{border:solid 1px white;outline:none;}"]),R=i.ZP.div.withConfig({displayName:"LoginMenu__ErrorArea",componentId:"sc-7cctlv-4"})(["background-color:red;text-align:center;width:220px;border-radius:5px;padding:3px;& p{font-size:10pt;}"]),U=i.ZP.button.withConfig({displayName:"LoginMenu__Button",componentId:"sc-7cctlv-5"})(["display:block;background:rgb(50,50,50);border:solid 1px gray;margin:5px auto;padding:7px;color:white;&:focus{outline:none;}&:hover:not(:disabled){background:rgb(80,80,80);}&:active:not(:disabled){border:solid 1px white;}&:disabled{color:gray;cursor:not-allowed;}"]),E=(0,i.F4)(["0%{margin-left:0;width:0%;}50%{margin-left:0;width:100%;}51%{margin-left:auto;}100%{margin-left:auto;width:0;}"]),T=i.ZP.div.withConfig({displayName:"LoginMenu__Loading",componentId:"sc-7cctlv-6"})(['height:2px;display:flex;&::before{content:"";display:block;background-color:white;width:0%;height:100%;animation:'," 1s infinite;}"],E);function A(e){var n=new N,t=(0,k.useState)(),i=t[0],o=t[1],a=(0,k.useState)(!1),s=a[0],c=a[1];return(0,r.jsx)(S,{children:(0,r.jsxs)(L,{onSubmit:function(t){t.preventDefault();var i=t.target.username.value,r=t.target.password.value;if(""===i||""===r){o("Preencha todos os campos");return}c(!0),n.login(i,r,e.onSuccess,function(e){c(!1),o(e)})},children:[(0,r.jsx)(F,{children:"Login"}),(0,r.jsx)(z,{placeholder:"Username",id:"username",required:!0}),(0,r.jsx)(z,{placeholder:"Password",id:"password",type:"password",required:!0}),i&&!s&&(0,r.jsx)(R,{children:(0,r.jsx)("p",{children:i})}),s&&(0,r.jsx)(T,{}),(0,r.jsx)(U,{disabled:s,children:"Login"})]})})}var M=t(9603),B=t(9417),G=i.ZP.div.withConfig({displayName:"styles__VideoCont",componentId:"sc-1we10of-0"})(["display:flex;background-color:black;color:white;z-index:1;overflow:hidden;position:fixed;top:0;bottom:0;left:0;right:0;& .hide{transition:0.5s;opacity:0;cursor:none;}"]),V=i.ZP.video.withConfig({displayName:"styles__VideoElement",componentId:"sc-1we10of-1"})(["width:100%;height:100%;margin:auto;"]),Y=i.ZP.div.withConfig({displayName:"styles__VideoMain",componentId:"sc-1we10of-2"})(["top:0;bottom:0;left:0;right:0;position:absolute;display:flex;flex-direction:column;"]),O=i.ZP.div.withConfig({displayName:"styles__VideoTop",componentId:"sc-1we10of-3"})(["color:white;padding:15px;background-image:linear-gradient(to bottom,rgba(0,0,0,0.8),transparent);user-select:none;"]),q=i.ZP.h2.withConfig({displayName:"styles__VideoTitle",componentId:"sc-1we10of-4"})(["text-align:center;margin:0 60px;white-space:nowrap;overflow-x:hidden;text-overflow:ellipsis;"]),Q=i.ZP.div.withConfig({displayName:"styles__VideoCenter",componentId:"sc-1we10of-5"})(["height:100%;display:flex;"]),J=(0,i.F4)(["to{transform:rotate(0);}from{transform:rotate(-360deg);}"]),X=i.ZP.div.withConfig({displayName:"styles__VideoLoading",componentId:"sc-1we10of-6"})(["margin:auto;border-radius:50%;width:120px;height:120px;border:solid 10px transparent;border-left-color:white;animation:"," 0.7s linear infinite;"],J),D=i.ZP.div.withConfig({displayName:"styles__VideoBottom",componentId:"sc-1we10of-7"})(["padding:10px;display:flex;background-image:linear-gradient(to bottom,transparent,rgba(0,0,0,0.8));"]),H=i.ZP.button.withConfig({displayName:"styles__VideoButton",componentId:"sc-1we10of-8"})(["background-color:transparent;border:none;color:white;font-size:13pt;margin:0 5px;font-size:20px;text-align:center;width:28px;&:hover{color:lightgray;transform:translateY(-1px);}"]),$=i.ZP.div.withConfig({displayName:"styles__CenterButtons",componentId:"sc-1we10of-9"})(["margin:auto;display:flex;& button{color:white;background-color:rgba(0,0,0,0.5);border:none;border-radius:50%;transition:0.1s;margin:auto 10px;&:hover{transform:translateY(-1px);box-shadow:0 2px 5px 1px black;}}& .buttonBig{font-size:50px;width:100px;height:100px;&:hover{font-size:52px;}}& .buttonSmall{width:50px;height:50px;font-size:25px;&:hover{font-size:26px;}}"]),K=i.ZP.a.withConfig({displayName:"styles__VideoCloseButton",componentId:"sc-1we10of-10"})(["background-color:transparent;border:none;color:white;font-size:13pt;font-size:20px;text-align:center;position:absolute;top:0;left:0;margin:10px 15px;&:hover{color:lightgray;transform:translateY(-1px);}"]),W=i.ZP.div.withConfig({displayName:"styles__VideoProgress",componentId:"sc-1we10of-11"})(["width:100%;margin:auto 0;"]),ee=i.ZP.div.withConfig({displayName:"styles__VideoVolume",componentId:"sc-1we10of-12"})(["border-radius:10px;overflow:show;display:flex;flex-direction:column;transition:320ms;& .volume{height:100%;width:10px;background-color:#999;margin:0 auto;border-radius:15px;overflow:hidden;display:flex;flex-direction:column;cursor:pointer;}& .volume .volume_percent{width:100%;margin-top:auto;background-color:white;transition:all 0.2s ease 0s;}&:hover{background-color:#444;padding:10px 0 5px 0;margin-top:-105px;}& button{margin:0 !important;}"]),en=i.ZP.h1.withConfig({displayName:"styles__Error",componentId:"sc-1we10of-13"})(["margin:auto;color:#ff5b5b;"]),et=t(29),ei=t(4687),eo=t.n(ei),er=t(2568),ea=t.n(er),es=function(){var e;function n(){(0,j.Z)(this,n)}return(0,C.Z)(n,[{key:"setVideoTime",value:function(e,n){if(!(n<=0)){var t=localStorage.videos?JSON.parse(localStorage.videos):{};t[ea()(e)]=n,localStorage.videos=JSON.stringify(t)}}},{key:"getVideoTime",value:function(e){if(!localStorage.videos)return localStorage.videos=JSON.stringify({}),0;var n=JSON.parse(localStorage.videos),t=ea()(e);return n[t]?n[t]:0}},{key:"startAutoSaving",value:(e=(0,et.Z)(eo().mark(function e(n,t){var i=this;return eo().wrap(function(e){for(;;)switch(e.prev=e.next){case 0:if(!(!t||!t.src)){e.next=2;break}return e.abrupt("return");case 2:this.setVideoTime(n,t.currentTime),setTimeout(function(){i.startAutoSaving(n,t)},1e3);case 4:case"end":return e.stop()}},e,this)})),function(n,t){return e.apply(this,arguments)})}]),n}(),ec=i.ZP.div.withConfig({displayName:"styles__RangeElement",componentId:"sc-yo8baf-0"})(["cursor:pointer;user-select:none;display:flex;flex-direction:column;"]),el=i.ZP.div.withConfig({displayName:"styles__Progress",componentId:"sc-yo8baf-1"})(["background-color:#D9D9D9;display:flex;height:5px;margin:5px 6px;border-radius:5px;box-shadow:0 0 5px 0 rgba(0,0,0,0.1);"]),ed=i.ZP.div.withConfig({displayName:"styles__ProgressBar",componentId:"sc-yo8baf-2"})(['background-color:white;height:100%;border-radius:5px;z-index:1;&::before{content:"";display:block;position:relative;margin:-5px -7px 0 auto;width:5px;height:5px;background-color:white;border:solid 5px white;border-radius:50%;box-shadow:0 0 5px 0 rgba(0,0,0,0.1);}']),eu=i.ZP.div.withConfig({displayName:"styles__ProgressFollower",componentId:"sc-yo8baf-3"})(["border-radius:5px 0px 0px 5px;height:100%;width:50%;background-color:rgba(0,0,0,0.25);display:flex;"]);function ep(e){var n,t=(0,k.useState)(null!==(n=e.percent)&&void 0!==n?n:0),i=t[0],o=t[1],a=(0,k.useState)(0),s=a[0],c=a[1],l=(0,k.useState)(!1),d=l[0],u=l[1],p=(0,k.useRef)(),f=(0,k.useRef)();function g(n){u(!1);var t=h(n);e.onInput&&e.onInput(t)&&o(t)}function h(e){var n=p.current.getBoundingClientRect(),t=(e.clientX-n.left)*100/(n.right-n.left);return t<0?0:t>100?100:t}return(0,k.useEffect)(function(){d||o(e.percent)},[e.percent]),(0,r.jsx)(ec,{onMouseUp:g,onMouseMove:function(n){var t=1==n.buttons;u(t);var i=h(n);if(!t){c(e.follower&&i);return}if(e.live){g(n);return}c(0),o(i)},onMouseLeave:function(){c(0),u(!1)},children:(0,r.jsxs)(el,{ref:p,children:[(0,r.jsx)(ed,{style:{width:"".concat(i,"%")}}),(0,r.jsx)(eu,{style:{marginLeft:"-".concat(i,"%"),width:"".concat(s,"%")},ref:f})]})})}function ef(e){return decodeURIComponent(e).replace(/\/+$/,"").replace(/^([a-zA-Z]+:\/\/)?\/?([^\/]+\/)+/,"").replace(/\.[a-zA-Z0-9]+$/,"")}function eg(e){var n=e%60,t=(e-n)/60/60,i="".concat(((e-n)/60%60).toFixed(0).padStart(2,"0"),":").concat(n.toFixed(0).padStart(2,"0"));return t>=1&&(i="".concat(t.toFixed(0).padStart(2,"0"),":").concat(i)),i}var eh=0;function em(e){var n=(0,k.useState)(0),t=n[0],i=n[1],o=(0,k.useState)(!0),a=o[0],s=o[1],c=(0,k.useState)(!1),l=c[0],d=c[1],u=(0,k.useState)(null),p=u[0],f=u[1],g=(0,k.useRef)(null),h=(0,k.useRef)(null),m=(0,k.useRef)(null),x=(0,k.useRef)(null),v=(0,k.useRef)(null),y=new es;function w(){h.current.classList&&h.current.classList.remove("hide"),eh<=0&&function e(){setTimeout(function(){if(--eh>0){e();return}h.current&&!v.current.paused&&h.current.classList.add("hide")},1e3)}(),eh=3}function b(){a||p||(w(),l?v.current.pause():v.current.play(),f(!1),s(!1))}function _(){d(!v.current.paused)}if(null==e.src)return(0,r.jsx)(r.Fragment,{});var j=ef(e.src);return(0,r.jsxs)(G,{ref:g,onMouseMove:w,children:[(0,r.jsx)(V,{onPlay:_,onPause:_,onTimeUpdate:function(){i(100*v.current.currentTime/v.current.duration)},onError:function(){s(!1),f(v.current.error.message)},onCanPlay:function(){if(a){x.current.style.height=100*v.current.volume+"%";var e=y.getVideoTime(v.current.src);e>0&&v.current.duration-15>e&&(v.current.currentTime=e),s(!1),y.startAutoSaving(v.current.src,v.current)}},src:e.src,autoPlay:!0,controls:!1,ref:v}),(0,r.jsxs)(Y,{ref:h,children:[(0,r.jsxs)(O,{children:[(0,r.jsx)(q,{children:j}),(0,r.jsx)(K,{style:{display:e.backUrl?"":"none"},href:e.backUrl,onClick:function(){v.current.src=null,d(!1),i(0),s(!0)},children:(0,r.jsx)(M.G,{icon:B.EyR})})]}),(0,r.jsxs)(Q,{children:[a&&(0,r.jsx)(X,{}),p&&(0,r.jsx)(en,{children:"Erro ao carregar v\xeddeo"}),!a&&!p&&(0,r.jsxs)($,{children:[(0,r.jsx)("button",{className:"buttonSmall",onClick:function(){v.current.currentTime-=5},children:(0,r.jsx)(M.G,{icon:B.XnX})}),(0,r.jsx)("button",{className:"buttonBig",onClick:b,children:(0,r.jsx)(M.G,{icon:l?B.XQY:B.zc})}),(0,r.jsx)("button",{className:"buttonSmall",onClick:function(){v.current.currentTime+=5},children:(0,r.jsx)(M.G,{icon:B.mHK})})]})]}),(0,r.jsxs)(D,{children:[(0,r.jsx)(H,{onClick:b,children:(0,r.jsx)(M.G,{icon:l?B.XQY:B.zc})}),(0,r.jsx)(W,{children:(0,r.jsx)(ep,{percent:t,onInput:function(e){return!a&&!p&&(v.current.currentTime=v.current.duration/100*e,i(e),!0)},follower:!0})}),(0,r.jsxs)(ee,{children:[(0,r.jsx)("div",{className:"volume",ref:m,onClick:function(e){var n=m.current.getBoundingClientRect(),t=(n.bottom-e.clientY)*1/(n.bottom-n.top);v.current.volume=t,x.current.style.height=100*t+"%"},children:(0,r.jsx)("div",{className:"volume_percent",ref:x})}),(0,r.jsx)(H,{children:(0,r.jsx)(M.G,{icon:B.ihg})})]}),(0,r.jsx)(H,{onClick:function(){document.fullscreenElement?(document.exitFullscreen(),screen.orientation.unlock()):(g.current.requestFullscreen(),screen.orientation.lock("landscape"))},children:(0,r.jsx)(M.G,{icon:B.TL5})})]})]})]})}var ex=t(983),ev=function(){function e(){(0,j.Z)(this,e),(0,P.Z)(this,"API_URL","/api"),(0,P.Z)(this,"API_QUERY","?path=/{0}"),(0,P.Z)(this,"SRC_QUERY","?path=/{0}"),this.api=I.Z.create({baseURL:"".concat(this.API_URL),timeout:5e3})}return(0,C.Z)(e,[{key:"getFiles",value:function(e,n,t){var i=this,o=this.clearPath(e);this.api.get("/files".concat(this.getQuery(o))).then(function(e){if(204==e.status)return n([],o);var t=Object.values(e.data.files).map(function(e){if(!e.type){var n=(0,ex.lookup)(e.name);n&&(e.type=n)}return e.icon&&(e.icon=i.getFileSrc(e.icon)),e});n(t=t.sort(function(e,n){return e.is_dir==n.is_dir?e.name.localeCompare(n.name,void 0,{numeric:!0}):e.is_dir?-1:1}),o)}).catch(function(e){if(console.error(e),t){var n=500;try{var o=e.toJSON();o&&o.status&&(n=o.status)}catch(e){}var r=i.getErrorMessage(n);t(n,r)}})}},{key:"openFile",value:function(e,n){var t=n.replace(/\/[^\/]+\/?$/,"");return{name:e.name,type:e.type,parent:t,src:this.getFileSrc(n)}}},{key:"getFileSrc",value:function(e){return"".concat(this.API_URL,"/files/open").concat(this.getSrcQuery(e))}},{key:"clearPath",value:function(e){return null==e?"":decodeURI(e.replace(/\/\/+/,"/").replace(/^\/+/,"").replace(/\/+$/,"").trim())}},{key:"getErrorMessage",value:function(e){switch(e){case 404:return"Arquivo ou diret\xf3rio n\xe3o encontrado!";case 403:return"Voc\xea n\xe3o tem permiss\xe3o para acessar esse arquivo ou diret\xf3rio!";case 500:return"Erro interno ao processar arquivo!";default:return"Erro desconhecido ao processar requisi\xe7\xe3o!"}}},{key:"getQuery",value:function(e){return this.API_QUERY.replace("{0}",encodeURIComponent("".concat(e)))}},{key:"getSrcQuery",value:function(e){return this.SRC_QUERY.replace("{0}",encodeURIComponent("".concat(e)))}}]),e}(),ey=(0,i.F4)(["from{transform:translateX(100%);}to{transform:translateY(0);}"]),ew=i.ZP.div.withConfig({displayName:"styles__AudioContent",componentId:"sc-1cnkxui-0"})(["position:fixed;bottom:10px;right:10px;width:580px;transition:200ms;animation:"," 200ms linear normal;display:flex;flex-direction:column;z-index:1;@media(max-width:780px){width:auto;left:10px;}"],ey),eb=i.ZP.div.withConfig({displayName:"styles__AudioElement",componentId:"sc-1cnkxui-1"})(["background:linear-gradient(90deg,#006DAC,#00A2FF);box-shadow:0 4px 4px 0px rgba(0,0,0,0.25);display:flex;flex-direction:column;height:90px;border-radius:15px;width:100%;"]),e_=i.ZP.div.withConfig({displayName:"styles__ContentHeader",componentId:"sc-1cnkxui-2"})(["display:flex;& .playlist-button{& .icon{transition:transform 500ms;}& .down{transform:rotate(-180deg);}}"]),ek=i.ZP.div.withConfig({displayName:"styles__ControlContent",componentId:"sc-1cnkxui-3"})(["display:flex;margin:0 0 0 15px;"]),ej=i.ZP.button.withConfig({displayName:"styles__ControlButton",componentId:"sc-1cnkxui-4"})(["background-color:transparent;cursor:pointer;border:none;color:white;margin:auto 6px;font-size:22pt;transition:200ms;width:25px;min-width:25px;&:hover{color:#d9d9d9;transform:translateY(-1px);}"]),eC=(0,i.F4)(["from{transform:rotate(0);}to{transform:rotate(360deg);}"]),eP=i.ZP.div.withConfig({displayName:"styles__LoadingSpin",componentId:"sc-1cnkxui-5"})(['display:flex;&:before{content:"";width:15px;height:15px;margin:auto;border-radius:50%;border:solid 5px transparent;border-top-color:white;animation:'," 500ms linear infinite;}"],eC),eI=i.ZP.div.withConfig({displayName:"styles__VolumeControl",componentId:"sc-1cnkxui-6"})(["display:flex;"]),eN=i.ZP.div.withConfig({displayName:"styles__VolumeProgress",componentId:"sc-1cnkxui-7"})(["width:75px;margin:auto 0;"]),eS=i.ZP.h3.withConfig({displayName:"styles__AudioTitle",componentId:"sc-1cnkxui-8"})(["white-space:nowrap;overflow-x:hidden;text-overflow:ellipsis;text-align:center;width:100%;margin:auto 15px;"]),eZ=i.ZP.div.withConfig({displayName:"styles__AudioDurationContent",componentId:"sc-1cnkxui-9"})(["display:flex;flex-direction:column;"]),eL=i.ZP.p.withConfig({displayName:"styles__AudioDurationCount",componentId:"sc-1cnkxui-10"})(["color:white;font-size:10pt;margin:0 15px;text-align:right;"]),eF=i.ZP.div.withConfig({displayName:"styles__AudioProgress",componentId:"sc-1cnkxui-11"})(["margin:auto 10px;"]),ez=i.ZP.div.withConfig({displayName:"PlayList__PlayListContent",componentId:"sc-1p83xcd-0"})(["background-color:#0B4F75;box-shadow:0 5px 5px 0 rgba(0,0,0,0.25);display:flex;flex-direction:column;height:200px;margin-top:20px;margin-bottom:-10px;padding-bottom:15px;border-radius:15px 15px 0 0;overflow-y:hidden;transition:height 500ms;"]),eR=i.ZP.div.withConfig({displayName:"PlayList__PlaylistHeader",componentId:"sc-1p83xcd-1"})(["padding:10px;text-align:center;border-radius:15px 15px 0 0;background-color:rgba(0,0,0,0.2);overflow-y:hidden;"]),eU=i.ZP.div.withConfig({displayName:"PlayList__MusicCol",componentId:"sc-1p83xcd-2"})(["display:flex;flex-direction:column;overflow-y:scroll;height:100%;"]),eE=i.ZP.div.withConfig({displayName:"PlayList__MusicRow",componentId:"sc-1p83xcd-3"})(["display:flex;& p{display:block;background-color:transparent;border:none;color:white;font-weight:600;white-space:nowrap;overflow-x:hidden;text-overflow:ellipsis;font-size:11pt;padding:5px;cursor:pointer;&:hover{text-decoration:underline;}}"]);function eT(e){var n=(0,k.useState)(null),t=n[0],i=n[1];return(0,k.useEffect)(function(){i(e.playing)},[e.playing]),(0,r.jsxs)(ez,{style:e.open?{}:{height:0,padding:0},children:[(0,r.jsx)(eR,{children:(0,r.jsx)("h3",{children:"Lista de m\xfasicas"})}),(0,r.jsx)(eU,{children:e.playlist.map(function(n,i){return(0,r.jsxs)(eE,{onClick:function(){e.onClick&&e.onClick(i)},children:[(0,r.jsxs)("p",{children:[i+1,". ",n]}),null!=t&&i==t&&(0,r.jsx)(M.G,{icon:B.ihg,style:{margin:"auto 5px auto auto"}})]},i)})})]})}function eA(e){var n=e.playlist,t=(0,k.useState)(e.src),i=t[0],o=t[1],a=(0,k.useState)(!1),s=a[0],c=a[1],l=(0,k.useState)(!1),d=l[0],u=l[1],p=(0,k.useState)(!0),f=p[0],g=p[1],h=(0,k.useState)(!1),m=h[0],x=h[1],v=(0,k.useState)(0),y=v[0],w=v[1],b=(0,k.useState)(0),_=b[0],j=b[1],C=(0,k.useState)("00:00"),P=C[0],I=C[1],N=(0,k.useState)("00:00"),S=N[0],Z=N[1],L=(0,k.useState)(!1),F=L[0],z=L[1],R=(0,k.useState)(null),U=R[0],E=R[1],T=(0,k.useState)(!1),A=T[0],G=T[1],V=(0,k.useRef)();(0,k.useEffect)(function(){null!=e.src&&(e.src==i?V.current.currentTime=0:o(e.src))},[e.src]),(0,k.useEffect)(function(){g(!0),d&&!(null!=U&&U.length==n.length&&0==n.filter(function(e){return!U.includes(e)}).length)&&J(!0)},[i]);var Y=ef(i);function O(){x(!V.current.paused)}function q(){if(n.length<=1){V.current.currentTime=0;return}g(!0);var e=d?U:n,t=e.indexOf(i);if(t<0||t+1>=e.length){o(e[0]);return}o(e[t+1])}function Q(){if(V.current.currentTime>1||n.length<=1){V.current.currentTime=0;return}var e=d?U:n;g(!0);var t=e.indexOf(i);if(t<=0){o(e[n.length-1]);return}o(e[t-1])}function J(){var e=arguments.length>0&&void 0!==arguments[0]&&arguments[0];n&&!(n.length<=2)&&E((e||null==U?n.map(function(e){return e}):U).sort(function(){return Math.random()-.5}))}return(0,r.jsxs)(ew,{children:[(0,r.jsx)(eT,{open:F,playlist:n.map(function(e){return ef(e)}),playing:i?n.indexOf(i):null,onClick:function(e){o(n[e])}}),(0,r.jsxs)(eb,{children:[(0,r.jsx)(e_,{children:(0,r.jsx)(ej,{style:{height:"16px",display:"flex",marginLeft:"auto",padding:"5px"},onClick:function(){z(!F)},className:"playlist-button",children:(0,r.jsx)(M.G,{icon:B.onQ,style:{fontSize:"16pt",margin:"auto"},className:"icon "+(F?"down":"")})})}),(0,r.jsxs)(ek,{children:[(0,r.jsx)(ej,{onClick:Q,disabled:n.length<=0,children:(0,r.jsx)(M.G,{icon:B.J0P})}),(0,r.jsx)(ej,{onClick:function(){m?V.current.pause():V.current.play()},children:f?(0,r.jsx)(eP,{}):(0,r.jsx)(M.G,{icon:m?B.XQY:B.zc})}),(0,r.jsx)(ej,{onClick:q,disabled:n.length<=0,children:(0,r.jsx)(M.G,{icon:B.Jwg})}),(0,r.jsx)(ej,{onClick:function(){var e=!d;u(e),e?J():E(null)},children:(0,r.jsx)(M.G,{icon:B.a_u,style:{color:d?"lightgray":"white"}})}),(0,r.jsxs)(eI,{children:[(0,r.jsx)(ej,{style:{display:"flex"},onClick:function(){var e=!s;V.current.volume=e?0:_/100,c(e)},children:(0,r.jsx)(M.G,{icon:s?B.YLJ:B.ihg,style:{fontSize:"16pt"}})}),(0,r.jsx)(eN,{children:(0,r.jsx)(ep,{percent:_,onInput:function(e){return s||(V.current.volume=e/100),localStorage.setItem("audio_volume",e.toFixed(2)),j(e),!0},live:!0})})]}),(0,r.jsx)(ej,{onClick:function(){navigator.mediaSession.metadata.title=A?Y:"Raspadmin Music Player",G(!A)},children:(0,r.jsx)(M.G,{icon:A?B.Mdf:B.Aq,style:{fontSize:"16pt"}})}),(0,r.jsx)(eS,{children:A?"...":Y})]}),(0,r.jsxs)(eZ,{children:[(0,r.jsxs)(eL,{children:[S,"/",P]}),(0,r.jsx)(eF,{children:(0,r.jsx)(ep,{percent:y,follower:!0,onInput:function(e){return V.current.currentTime=V.current.duration/100*e,w(e),!0}})})]}),(0,r.jsx)("audio",{autoPlay:!0,src:i,onPlay:O,onPause:O,onCanPlay:function(){if(f){navigator.mediaSession.metadata=new MediaMetadata({title:A?"Raspadmin Music Player":Y,artwork:[{src:"/img/icons/music.svg"}]}),navigator.mediaSession.setActionHandler("previoustrack",Q),navigator.mediaSession.setActionHandler("nexttrack",q);var e,n=(e=localStorage.getItem("audio_volume")?Number(localStorage.getItem("audio_volume")):50)<0?0:e;j(n),V.current.volume=s?0:n/100,g(!1),I(eg(V.current.duration))}},onTimeUpdate:function(){w(100*V.current.currentTime/V.current.duration),Z(eg(V.current.currentTime))},onEnded:q,ref:V})]})]})}var eM=function(e){return e.match(/audio\/(mpeg|mp3|ogg|(x-(pn-)?)?wav)/)},eB=function(e){return e.match(/image\/(png|jpe?g|svg|webp)/)},eG=i.ZP.div.withConfig({displayName:"styles__ImagemContainer",componentId:"sc-hemevv-0"})(["position:fixed;display:flex;bottom:0;top:0;left:0;right:0;z-index:1;text-align:center;background-color:rgb(0,0,0);"]),eV=(0,i.F4)(["0%{background-color:rgb(120,120,120);}25%{background-color:rgb(80,80,80);}50%{background-color:rgb(80,80,80);}75%{background-color:rgb(120,120,120);}"]),eY=i.ZP.img.withConfig({displayName:"styles__Img",componentId:"sc-hemevv-1"})(["max-width:100%;max-height:100vh;background-color:rgb(120,120,120);animation:"," 2s linear infinite;"],eV),eO=i.ZP.div.withConfig({displayName:"styles__Controls",componentId:"sc-hemevv-2"})(["display:flex;width:100%;height:100%;position:absolute;"]),eq=i.ZP.a.withConfig({displayName:"styles__CloseLink",componentId:"sc-hemevv-3"})(["display:flex;z-index:1;position:absolute;text-align:right;font-size:18pt;right:5px;top:5px;border-radius:25%;width:32px;height:32px;background-color:rgba(0,0,0,0.5);"]),eQ=i.ZP.a.withConfig({displayName:"styles__ControlLink",componentId:"sc-hemevv-4"})(["margin-top:auto;margin-left:5px;margin-right:5px;margin-bottom:auto;font-size:35pt;padding:5px;border-radius:25%;background-color:rgba(0,0,0,0.5);"]);function eJ(e){return(0,r.jsxs)(eG,{children:[e.closeUrl&&(0,r.jsx)(eq,{href:e.closeUrl,children:(0,r.jsx)(M.G,{icon:B.YIN,style:{margin:"auto"}})}),(0,r.jsxs)(eO,{children:[e.backUrl&&(0,r.jsx)(eQ,{href:e.backUrl,children:(0,r.jsx)(M.G,{icon:B.EyR})}),e.nextUrl&&(0,r.jsx)(eQ,{href:e.nextUrl,style:{marginLeft:"auto"},children:(0,r.jsx)(M.G,{icon:B.yOZ})})]}),(0,r.jsx)("div",{style:{alignSelf:"center",margin:"auto"},children:(0,r.jsx)(eY,{src:e.src})})]})}var eX=i.ZP.div.withConfig({displayName:"pages__Container",componentId:"sc-keronp-0"})(['display:grid;grid-template-columns:220px auto;grid-template-rows:64px auto;grid-template-areas:"h n" "m a";height:100vh;transition:grid-template-columns .2s;@media(max-width:950px){grid-template-columns:0 auto;}']),eD=i.ZP.header.withConfig({displayName:"pages__Header",componentId:"sc-keronp-1"})(["grid-area:h;display:flex;overflow:hidden;background:rgba(0,0,0,0.5);& .title{margin:auto;}"]),eH=i.ZP.button.withConfig({displayName:"pages__CollapseButtom",componentId:"sc-keronp-2"})(["display:none;color:white;background-color:transparent;border:none;font-size:15pt;margin:auto 20px;cursor:pointer;&:hover{color:#dddddd;}@media(max-width:950px){display:block;}"]),e$=i.ZP.nav.withConfig({displayName:"pages__Nav",componentId:"sc-keronp-3"})(["grid-area:n;display:flex;background:rgba(0,0,0,0.5);overflow-x:auto;white-space:nowrap;"]),eK=i.ZP.main.withConfig({displayName:"pages__Main",componentId:"sc-keronp-4"})(["grid-area:m;overflow-y:scroll;background:rgba(0,0,0,0.5);"]),eW=i.ZP.aside.withConfig({displayName:"pages__Aside",componentId:"sc-keronp-5"})(["grid-area:a;overflow-y:scroll;background:rgba(9,9,9,0.3);"]),e0=i.ZP.div.withConfig({displayName:"pages__PathLink",componentId:"sc-keronp-6"})(["font-size:11pt;font-weight:bold;margin:auto 25px;color:white;& a{color:white;margin:0 2px;padding:2px;border-radius:5px;&:hover{background-color:rgba(255,255,255,0.3);}}"]),e1=i.ZP.input.withConfig({displayName:"pages__SearchInput",componentId:"sc-keronp-7"})(["background-color:rgba(0,0,0,0.3);margin:auto 25px auto auto;border:none;padding:5px;outline:none;color:white;font-size:12pt;"]);function e5(){var e=new ev,n=(0,k.useState)(""),t=n[0],i=n[1],o=(0,k.useState)([]),a=o[0],s=o[1],c=(0,k.useState)(null),l=c[0],d=c[1],u=(0,k.useState)(-1),p=u[0],f=u[1],g=(0,k.useState)(!1),h=g[0],m=g[1],x=(0,k.useState)(),v=x[0],w=x[1],b=(0,k.useState)(),j=b[0],C=b[1],P=(0,k.useState)(),I=P[0],N=P[1],S=(0,k.useState)([]),Z=S[0],L=S[1],F=(0,k.useState)(),z=F[0],R=F[1],U=(0,k.useState)([]),E=U[0],T=U[1],G=(0,k.useState)(!1),V=G[0],Y=G[1],O=(0,k.useState)(null),q=O[0],Q=O[1],J=(0,k.useState)(""),X=J[0],D=J[1];function H(){m(!1),e.getFiles(null,function(e){s(e.filter(function(e){return e.is_dir}).map(function(e){return e.href="#/".concat(e.name),e})),$()},function(e,n){if(401==e)return m(!0);w(n)})}function $(){var n=arguments.length>0&&void 0!==arguments[0]?arguments[0]:location.hash.substring(1),i=arguments.length>1&&void 0!==arguments[1]?arguments[1]:null;if(null!==l&&(null==I||I.parent!=decodeURIComponent(n))){var o=l.filter(function(e){return decodeURIComponent(e.href)==decodeURIComponent(t)});1!=o.length||o[0].is_dir?(D(""),d(null)):f(l.indexOf(o[0]))}w(null),I&&(I.src=null),e.getFiles(n,function(n,t){if(f(-1),1==n.length&&n[0].open){var o=e.openFile(n[0],t);$(o.parent,function(n){return function(n,t){if(N(null),C(null),R(null),n.type){if(n.type.match(/video\/(mp4|webm|ogg|mkv)/)){C(n);return}if(eM(n.type)){N(n),L(t?t.filter(function(e){return e.type&&eM(e.type)}).map(function(t){return e.getFileSrc("".concat(n.parent,"/").concat(t.name))}):[]),location.hash=n.parent;return}if(eB(n.type)){R(n),T(t?t.filter(function(e){return e.type&&eB(e.type)}).map(function(e){return e.href}):[]);return}}location.href=n.src}(o,n)});return}Q(t);var r=n.map(function(e){return e.href=t?"#/".concat(t,"/").concat(e.name):"#/".concat(e.name),e});d(r),i&&i(r)},function(e,n){if(401==e)return m(!0);w(n)})}return(0,k.useEffect)(function(){window.onhashchange=function(){return i(location.hash)},H()},[]),(0,k.useEffect)(function(){C(null),R(null),$()},[t]),(0,r.jsxs)(eX,{style:{gridTemplateColumns:V?"220px auto":null},children:[(0,r.jsx)(eD,{children:(0,r.jsx)("h2",{className:"title",children:(0,r.jsx)("a",{href:"#",children:"RaspAdmin"})})}),(0,r.jsxs)(e$,{children:[(0,r.jsx)(eH,{onClick:function(){Y(!V)},children:(0,r.jsx)(M.G,{icon:B.xiG})}),(0,r.jsxs)(e0,{children:["/",(0,r.jsx)("a",{href:"#/",children:"home"}),q&&q.split("/").map(function(e,n){var t="";return q.split("/").forEach(function(e,i){i<=n&&(t+="/".concat(e))}),(0,r.jsxs)(r.Fragment,{children:["/",(0,r.jsx)("a",{href:"#".concat(t),children:e},n)]})})]}),(0,r.jsx)(e1,{placeholder:"Pesquisar",onChange:function(e){return D(e.currentTarget.value)},value:X})]}),(0,r.jsx)(eK,{children:(0,r.jsx)(_,{files:a.filter(function(e){return e.is_dir})})}),(0,r.jsx)(eW,{children:(0,r.jsx)(y,{files:l,text:v,search:X,fileLoading:p})}),j&&(0,r.jsx)(em,{src:j.src,backUrl:"#".concat(j.parent)}),I&&(0,r.jsx)(eA,{src:I.src,playlist:Z}),z&&(0,r.jsx)(eJ,{src:z.src,closeUrl:"#".concat(z.parent),nextUrl:function(){var e=location.hash;if(!e||!z||!E)return null;var n=E.indexOf(e);return n<=E.length-1?E[n+1]:null}(),backUrl:function(){var e=location.hash;if(!e||!z||0==E.length)return null;var n=E.indexOf(e);return n>0?E[n-1]:null}()}),h&&(0,r.jsx)(A,{onSuccess:H})]})}},8312:function(e,n,t){(window.__NEXT_P=window.__NEXT_P||[]).push(["/",function(){return t(572)}])}},function(e){e.O(0,[976,116,888,774,179],function(){return e(e.s=8312)}),_N_E=e.O()}]);