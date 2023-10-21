(self.webpackChunk_N_E=self.webpackChunk_N_E||[]).push([[405],{8779:function(e,n,t){"use strict";t.r(n),t.d(n,{default:function(){return Ye}});var o=t(9521),i=t(2640),r=t(5893),a=function(e){if(e.is_dir)return"folder.svg";if(!e.type)return"document.svg";var n=e.type.toString().split("/"),t=(0,i.Z)(n,2),o=t[0],r=t[1];switch(o){case"video":return"video.svg";case"audio":return"music.svg";case"image":return"image.svg";case"application":switch(r){case"java-archive":return"java.svg";case"x-msdos-program":return"exe.svg";case"x-iso9660-image":case"octet-stream":return"iso.svg";case"x-msdownload":case"x-sh":return"document.svg"}return"compact.svg";case"text":return"x-java-source"===r?"java.svg":"document.svg"}return"document.svg"},s=o.ZP.a.withConfig({displayName:"FileBlock__FileCont",componentId:"sc-180mzed-0"})(["height:130px;margin:5px;text-align:center;overflow:hidden;font-weight:600;word-wrap:break-word;transition:background-color 0.5s;border-radius:5px;&:hover{background:rgba(255,255,255,0.3);overflow:inherit;z-index:1;transition:background-color 0.1s;}"]),c=o.ZP.div.withConfig({displayName:"FileBlock__FileIcon",componentId:"sc-180mzed-1"})(["width:80px;height:80px;margin:5px auto;border-radius:5px;background-size:cover;background-position:center;"]),l=o.ZP.p.withConfig({displayName:"FileBlock__Name",componentId:"sc-180mzed-2"})(["text-align:center;font-weight:bold;"]);function d(e){return(0,r.jsxs)(s,{href:e.file.href,children:[(0,r.jsx)(c,{style:{backgroundImage:"url('"+(e.file.icon?e.file.icon:"/img/icons/"+a(e.file))+"')"}}),(0,r.jsx)(l,{children:e.file.name})]})}var u=(0,o.F4)(["0%{margin-left:0;width:0;}50%{margin-left:0;width:100%;}100%{margin-left:100%;width:0;}"]),p=o.ZP.div.withConfig({displayName:"Loading__LoadingCont",componentId:"sc-4z1qry-0"})(["width:100%;"]),f=o.ZP.div.withConfig({displayName:"Loading__LoadingBar",componentId:"sc-4z1qry-1"})(["height:10px;background-color:white;animation:"," 1s ease infinite;"],u);function g(){return(0,r.jsx)(p,{children:(0,r.jsx)(f,{})})}var h=o.ZP.div.withConfig({displayName:"FilesBlocks__Panel",componentId:"sc-vrga00-0"})(["display:flex;flex-wrap:wrap;flex-direction:row;padding:10px;text-align:center;align-content:start;& a{width:calc(20% - 10px);}@media(min-width:1400px){& a{width:calc(14.2% - 10px);}}@media(max-width:680px){& a{width:calc(50% - 10px);}}"]),m=o.ZP.h1.withConfig({displayName:"FilesBlocks__Text",componentId:"sc-vrga00-1"})(["color:white;text-align:center;width:100%;"]);function x(e){if(e.text)return(0,r.jsx)(h,{children:(0,r.jsx)(m,{children:e.text})});if(null===e.files)return(0,r.jsx)(h,{children:(0,r.jsx)(g,{})});if(0==e.files.length)return(0,r.jsx)(h,{children:(0,r.jsx)(m,{children:"Essa pasta est\xe1 vazia!"})});var n=0;return(0,r.jsx)(h,{children:e.files.map((function(e){return(0,r.jsx)(d,{file:e},n++)}))})}var v=o.ZP.a.withConfig({displayName:"FileRow__Row",componentId:"sc-rb7ntb-0"})(["padding:12px;font-weight:600;white-space:nowrap;overflow-x:hidden;text-overflow:ellipsis;&:hover{background:rgba(255,255,255,0.3);}"]);function w(e){var n=e.src.split("/"),t=n[n.length-1];return(0,r.jsx)(v,{href:e.src,children:t})}var y=o.ZP.div.withConfig({displayName:"FilesList__Column",componentId:"sc-km3ln0-0"})(["display:flex;flex-direction:column;"]);function b(e){if(e.files){var n=0;return(0,r.jsx)(y,{children:e.files.map((function(e){return(0,r.jsx)(w,{src:e.href},++n)}))})}return(0,r.jsx)(y,{})}var _=t(7294),j=t(2777),k=t(2262),C=t(9499),P=t(9669),I=t.n(P),N=function(){function e(){var n;(0,j.Z)(this,e),(0,C.Z)(this,"API_URL",null!==(n="/api")?n:"/api"),(0,C.Z)(this,"api",void 0),this.api=I().create({baseURL:"".concat(this.API_URL,"/auth"),timeout:5e3})}return(0,k.Z)(e,[{key:"login",value:function(e,n,t,o){var i=new URLSearchParams;i.append("username",e),i.append("password",n),this.api.post("/login",i,{auth:{username:e,password:n}}).then(t).catch((function(e){if(o){var n="Erro interno ao processar requisi\xe7\xe3o";try{var t=JSON.parse(e.request.response);t.message&&(n=t.message)}catch(i){}o(n)}}))}}]),e}(),Z=o.ZP.div.withConfig({displayName:"LoginMenu__LoginCont",componentId:"sc-7cctlv-0"})(["display:flex;position:fixed;top:0;left:0;right:0;bottom:0;z-index:1;background:rgba(9,9,9,1);"]),S=(0,o.F4)(["0%{opacity:0;transform:translateY(-500px);}90%{opacity:100;transform:translateY(5px);}100%{opacity:100;transform:translateY(0);}"]),L=o.ZP.form.withConfig({displayName:"LoginMenu__LoginForm",componentId:"sc-7cctlv-1"})(["margin:auto;background:rgb(48,48,48);padding:15px 25px;display:block;border-radius:10px;animation:"," 0.8s normal;"],S),F=o.ZP.h2.withConfig({displayName:"LoginMenu__Title",componentId:"sc-7cctlv-2"})(["text-align:center;margin:15px 0;"]),z=o.ZP.input.withConfig({displayName:"LoginMenu__Input",componentId:"sc-7cctlv-3"})(["display:block;background:rgb(50,50,50);border:solid 1px gray;margin:10px auto;padding:5px;color:white;text-align:center;border-radius:5px;&:focus{border:solid 1px white;outline:none;}"]),R=o.ZP.div.withConfig({displayName:"LoginMenu__ErrorArea",componentId:"sc-7cctlv-4"})(["background-color:red;text-align:center;width:220px;border-radius:5px;padding:3px;transition:0.5s;& p{font-size:10pt;}"]),T=o.ZP.button.withConfig({displayName:"LoginMenu__Button",componentId:"sc-7cctlv-5"})(["display:block;background:rgb(50,50,50);border:solid 1px gray;margin:5px auto;padding:7px;color:white;&:focus{outline:none;}&:hover{background:rgb(80,80,80);}&:active{border:solid 1px white;}"]);function E(e){var n=new N,t=(0,_.useState)(),o=t[0],i=t[1];return(0,r.jsx)(Z,{children:(0,r.jsxs)(L,{onSubmit:function(t){t.preventDefault();var o=t.target.username.value,r=t.target.password.value;""!==o&&""!==r?n.login(o,r,e.onSuccess,(function(e){i(e)})):i("Preencha todos os campos")},children:[(0,r.jsx)(F,{children:"Login"}),(0,r.jsx)(z,{placeholder:"Username",id:"username",required:!0}),(0,r.jsx)(z,{placeholder:"Password",id:"password",type:"password",required:!0}),o&&(0,r.jsx)(R,{children:(0,r.jsx)("p",{children:o})}),(0,r.jsx)(T,{children:"Login"})]})})}var A=t(9603),M=t(9417),V=o.ZP.div.withConfig({displayName:"styles__VideoCont",componentId:"sc-1we10of-0"})(["display:flex;background-color:black;color:white;overflow:hidden;position:fixed;top:0;bottom:0;left:0;right:0;& .hide{transition:0.5s;opacity:0;cursor:none;}"]),B=o.ZP.video.withConfig({displayName:"styles__VideoElement",componentId:"sc-1we10of-1"})(["width:100%;height:100%;margin:auto;"]),U=o.ZP.div.withConfig({displayName:"styles__VideoMain",componentId:"sc-1we10of-2"})(["top:0;bottom:0;left:0;right:0;position:absolute;display:flex;flex-direction:column;"]),G=o.ZP.div.withConfig({displayName:"styles__VideoTop",componentId:"sc-1we10of-3"})(["color:white;padding:15px;background-image:linear-gradient(to bottom,rgba(0,0,0,0.8),transparent);user-select:none;"]),O=o.ZP.h2.withConfig({displayName:"styles__VideoTitle",componentId:"sc-1we10of-4"})(["text-align:center;margin:0 60px;white-space:nowrap;overflow-x:hidden;text-overflow:ellipsis;"]),Y=o.ZP.div.withConfig({displayName:"styles__VideoCenter",componentId:"sc-1we10of-5"})(["height:100%;display:flex;"]),q=(0,o.F4)(["to{transform:rotate(0);}from{transform:rotate(-360deg);}"]),X=o.ZP.div.withConfig({displayName:"styles__VideoLoading",componentId:"sc-1we10of-6"})(["margin:auto;border-radius:50%;width:120px;height:120px;border:solid 10px transparent;border-left-color:white;animation:"," 0.7s linear infinite;"],q),J=o.ZP.div.withConfig({displayName:"styles__VideoBottom",componentId:"sc-1we10of-7"})(["padding:10px;display:flex;background-image:linear-gradient(to bottom,transparent,rgba(0,0,0,0.8));"]),D=o.ZP.button.withConfig({displayName:"styles__VideoButton",componentId:"sc-1we10of-8"})(["background-color:transparent;border:none;color:white;font-size:13pt;margin:0 5px;font-size:20px;text-align:center;width:28px;&:hover{color:lightgray;transform:translateY(-1px);}"]),H=o.ZP.div.withConfig({displayName:"styles__CenterButtons",componentId:"sc-1we10of-9"})(["margin:auto;display:flex;& button{color:white;background-color:rgba(0,0,0,0.5);border:none;border-radius:50%;transition:0.1s;margin:auto 10px;&:hover{transform:translateY(-1px);box-shadow:0 2px 5px 1px black;}}& .buttonBig{font-size:50px;width:100px;height:100px;&:hover{font-size:52px;}}& .buttonSmall{width:50px;height:50px;font-size:25px;&:hover{font-size:26px;}}"]),Q=o.ZP.a.withConfig({displayName:"styles__VideoCloseButton",componentId:"sc-1we10of-10"})(["background-color:transparent;border:none;color:white;font-size:13pt;font-size:20px;text-align:center;position:absolute;top:0;left:0;margin:10px 15px;&:hover{color:lightgray;transform:translateY(-1px);}"]),$=o.ZP.div.withConfig({displayName:"styles__VideoProgress",componentId:"sc-1we10of-11"})(["width:100%;margin:auto 0;"]),K=o.ZP.div.withConfig({displayName:"styles__VideoVolume",componentId:"sc-1we10of-12"})(["border-radius:10px;overflow:show;display:flex;flex-direction:column;transition:320ms;& .volume{height:100%;width:10px;background-color:#999;margin:0 auto;border-radius:15px;overflow:hidden;display:flex;flex-direction:column;cursor:pointer;}& .volume .volume_percent{width:100%;margin-top:auto;background-color:white;transition:all 0.2s ease 0s;}&:hover{background-color:#444;padding:10px 0 5px 0;margin-top:-105px;}& button{margin:0 !important;}"]),W=o.ZP.h1.withConfig({displayName:"styles__Error",componentId:"sc-1we10of-13"})(["margin:auto;color:#ff5b5b;"]),ee=t(29),ne=t(7794),te=t.n(ne),oe=t(2568),ie=t.n(oe),re=function(){function e(){(0,j.Z)(this,e)}return(0,k.Z)(e,[{key:"setVideoTime",value:function(e,n){if(!(n<=0)){var t=localStorage.videos?JSON.parse(localStorage.videos):{};t[ie()(e)]=n,localStorage.videos=JSON.stringify(t)}}},{key:"getVideoTime",value:function(e){if(!localStorage.videos)return localStorage.videos=JSON.stringify({}),0;var n=JSON.parse(localStorage.videos),t=ie()(e);return n[t]?n[t]:0}},{key:"startAutoSaving",value:function(){var e=(0,ee.Z)(te().mark((function e(n,t){var o=this;return te().wrap((function(e){for(;;)switch(e.prev=e.next){case 0:if(t&&t.src){e.next=2;break}return e.abrupt("return");case 2:this.setVideoTime(n,t.currentTime),setTimeout((function(){o.startAutoSaving(n,t)}),1e3);case 4:case"end":return e.stop()}}),e,this)})));return function(n,t){return e.apply(this,arguments)}}()}]),e}(),ae=o.ZP.div.withConfig({displayName:"styles__RangeElement",componentId:"sc-yo8baf-0"})(["cursor:pointer;user-select:none;display:flex;flex-direction:column;"]),se=o.ZP.div.withConfig({displayName:"styles__Progress",componentId:"sc-yo8baf-1"})(["background-color:#D9D9D9;display:flex;height:5px;margin:5px 6px;border-radius:5px;box-shadow:0 0 5px 0 rgba(0,0,0,0.1);"]),ce=o.ZP.div.withConfig({displayName:"styles__ProgressBar",componentId:"sc-yo8baf-2"})(['background-color:white;height:100%;border-radius:5px;z-index:1;&::before{content:"";display:block;position:relative;margin:-5px -7px 0 auto;width:5px;height:5px;background-color:white;border:solid 5px white;border-radius:50%;box-shadow:0 0 5px 0 rgba(0,0,0,0.1);}']),le=o.ZP.div.withConfig({displayName:"styles__ProgressFollower",componentId:"sc-yo8baf-3"})(["border-radius:5px 0px 0px 5px;height:100%;width:50%;background-color:rgba(0,0,0,0.25);display:flex;"]);function de(e){var n,t=(0,_.useState)(null!==(n=e.percent)&&void 0!==n?n:0),o=t[0],i=t[1],a=(0,_.useState)(0),s=a[0],c=a[1],l=(0,_.useState)(!1),d=l[0],u=l[1],p=(0,_.useRef)(),f=(0,_.useRef)();function g(n){u(!1);var t=h(n);e.onInput&&e.onInput(t)&&i(t)}function h(e){var n=p.current.getBoundingClientRect(),t=100*(e.clientX-n.left)/(n.right-n.left);return t<0?0:t>100?100:t}return(0,_.useEffect)((function(){d||i(e.percent)}),[e.percent]),(0,r.jsx)(ae,{onMouseUp:g,onMouseMove:function(n){var t=1==n.buttons;u(t);var o=h(n);t?e.live?g(n):(c(0),i(o)):c(e.follower&&o)},onMouseLeave:function(){c(0),u(!1)},children:(0,r.jsxs)(se,{ref:p,children:[(0,r.jsx)(ce,{style:{width:"".concat(o,"%")}}),(0,r.jsx)(le,{style:{marginLeft:"-".concat(o,"%"),width:"".concat(s,"%")},ref:f})]})})}function ue(e){return decodeURIComponent(e).replace(/\/+$/,"").replace(/^([a-zA-Z]+:\/\/)?\/?([^\/]+\/)+/,"").replace(/\.[a-zA-Z0-9]+$/,"")}function pe(e){var n=e%60,t=(e-n)/60/60,o="".concat(((e-n)/60%60).toFixed(0).padStart(2,"0"),":").concat(n.toFixed(0).padStart(2,"0"));return t>=1&&(o="".concat(t.toFixed(0).padStart(2,"0"),":").concat(o)),o}var fe=0;function ge(e){var n=(0,_.useState)(0),t=n[0],o=n[1],i=(0,_.useState)(!0),a=i[0],s=i[1],c=(0,_.useState)(!1),l=c[0],d=c[1],u=(0,_.useState)(null),p=u[0],f=u[1],g=(0,_.useRef)(null),h=(0,_.useRef)(null),m=(0,_.useRef)(null),x=(0,_.useRef)(null),v=(0,_.useRef)(null),w=new re;function y(){h.current.classList&&h.current.classList.remove("hide"),fe<=0&&b(),fe=3}function b(){setTimeout((function(){--fe>0?b():h.current&&!v.current.paused&&h.current.classList.add("hide")}),1e3)}function j(){a||p||(y(),l?v.current.pause():v.current.play(),f(!1),s(!1))}function k(){d(!v.current.paused)}if(null==e.src)return(0,r.jsx)(r.Fragment,{});var C=ue(e.src);return(0,r.jsxs)(V,{ref:g,onMouseMove:y,children:[(0,r.jsx)(B,{onPlay:k,onPause:k,onTimeUpdate:function(){var e=100*v.current.currentTime/v.current.duration;o(e)},onError:function(){s(!1),f(v.current.error.message)},onCanPlay:function(){if(a){x.current.style.height=100*v.current.volume+"%";var e=w.getVideoTime(v.current.src);e>0&&v.current.duration-15>e&&(v.current.currentTime=e),s(!1),w.startAutoSaving(v.current.src,v.current)}},src:e.src,autoPlay:!0,controls:!1,ref:v}),(0,r.jsxs)(U,{ref:h,children:[(0,r.jsxs)(G,{children:[(0,r.jsx)(O,{children:C}),(0,r.jsx)(Q,{style:{display:e.backUrl?"":"none"},href:e.backUrl,onClick:function(){v.current.src=null,d(!1),o(0),s(!0)},children:(0,r.jsx)(A.G,{icon:M.EyR})})]}),(0,r.jsxs)(Y,{children:[a&&(0,r.jsx)(X,{}),p&&(0,r.jsx)(W,{children:"Erro ao carregar v\xeddeo"}),!a&&!p&&(0,r.jsxs)(H,{children:[(0,r.jsx)("button",{className:"buttonSmall",onClick:function(){v.current.currentTime-=5},children:(0,r.jsx)(A.G,{icon:M.XnX})}),(0,r.jsx)("button",{className:"buttonBig",onClick:j,children:(0,r.jsx)(A.G,{icon:l?M.XQY:M.zc})}),(0,r.jsx)("button",{className:"buttonSmall",onClick:function(){v.current.currentTime+=5},children:(0,r.jsx)(A.G,{icon:M.mHK})})]})]}),(0,r.jsxs)(J,{children:[(0,r.jsx)(D,{onClick:j,children:(0,r.jsx)(A.G,{icon:l?M.XQY:M.zc})}),(0,r.jsx)($,{children:(0,r.jsx)(de,{percent:t,onInput:function(e){return!a&&!p&&(v.current.currentTime=v.current.duration/100*e,o(e),!0)},follower:!0})}),(0,r.jsxs)(K,{children:[(0,r.jsx)("div",{className:"volume",ref:m,onClick:function(e){var n=m.current.getBoundingClientRect(),t=1*(n.bottom-e.clientY)/(n.bottom-n.top);v.current.volume=t,x.current.style.height=100*t+"%"},children:(0,r.jsx)("div",{className:"volume_percent",ref:x})}),(0,r.jsx)(D,{children:(0,r.jsx)(A.G,{icon:M.ihg})})]}),(0,r.jsx)(D,{onClick:function(){document.fullscreenElement?(document.exitFullscreen(),screen.orientation.unlock()):(g.current.requestFullscreen(),screen.orientation.lock("landscape"))},children:(0,r.jsx)(A.G,{icon:M.TL5})})]})]})]})}var he=t(983),me=function(){function e(){var n;(0,j.Z)(this,e),(0,C.Z)(this,"API_URL",null!==(n="/api")?n:"/api"),(0,C.Z)(this,"api",void 0),this.api=I().create({baseURL:"".concat(this.API_URL),timeout:5e3})}return(0,k.Z)(e,[{key:"getFiles",value:function(e,n,t){var o=this,i=this.clearPath(e);this.api.get("/files?path=".concat(encodeURIComponent("/".concat(i)))).then((function(e){if(204==e.status)return n([],i);var t=Object.values(e.data.files).map((function(e){if(!e.type){var n=(0,he.lookup)(e.name);n&&(e.type=n)}return e.icon&&(e.icon=o.getFileSrc(e.icon)),e}));t=t.sort((function(e,n){return e.is_dir==n.is_dir?e.name.localeCompare(n.name,void 0,{numeric:!0}):e.is_dir?-1:1})),n(t,i)})).catch((function(e){if(console.error(e),t){var n=500;try{var i=e.toJSON();i&&i.status&&(n=i.status)}catch(a){}var r=o.getErrorMessage(n);t(n,r)}}))}},{key:"openFile",value:function(e,n){var t=n.replace(/\/[^\/]+\/?$/,"");return{name:e.name,type:e.type,parent:t,src:this.getFileSrc(n)}}},{key:"getFileSrc",value:function(e){return"".concat(this.API_URL,"/files/open?path=/").concat(encodeURIComponent(e))}},{key:"clearPath",value:function(e){return null==e?"":decodeURI(e.replace(/\/\/+/,"/").replace(/^\/+/,"").replace(/\/+$/,"").trim())}},{key:"getErrorMessage",value:function(e){switch(e){case 404:return"Arquivo ou diret\xf3rio n\xe3o encontrado!";case 403:return"Voc\xea n\xe3o tem permiss\xe3o para acessar esse arquivo ou diret\xf3rio!";case 500:return"Erro interno ao processar arquivo!";default:return"Erro desconhecido ao processar requisi\xe7\xe3o!"}}}]),e}(),xe=(0,o.F4)(["from{transform:translateX(100%);}to{transform:translateY(0);}"]),ve=o.ZP.div.withConfig({displayName:"styles__AudioContent",componentId:"sc-1cnkxui-0"})(["position:fixed;bottom:10px;right:10px;width:580px;transition:200ms;animation:"," 200ms linear normal;display:flex;flex-direction:column;z-index:1;@media(max-width:780px){width:auto;left:10px;}"],xe),we=o.ZP.div.withConfig({displayName:"styles__AudioElement",componentId:"sc-1cnkxui-1"})(["background:linear-gradient(90deg,#006DAC,#00A2FF);box-shadow:0 4px 4px 0px rgba(0,0,0,0.25);display:flex;flex-direction:column;height:90px;border-radius:15px;width:100%;"]),ye=o.ZP.div.withConfig({displayName:"styles__ContentHeader",componentId:"sc-1cnkxui-2"})(["display:flex;"]),be=o.ZP.div.withConfig({displayName:"styles__ControlContent",componentId:"sc-1cnkxui-3"})(["display:flex;margin:0 0 0 15px;"]),_e=o.ZP.button.withConfig({displayName:"styles__ControlButton",componentId:"sc-1cnkxui-4"})(["background-color:transparent;cursor:pointer;border:none;color:white;margin:auto 6px;font-size:22pt;transition:200ms;&:hover{color:#d9d9d9;transform:translateY(-1px);}"]),je=(0,o.F4)(["from{transform:rotate(0);}to{transform:rotate(360deg);}"]),ke=o.ZP.div.withConfig({displayName:"styles__LoadingSpin",componentId:"sc-1cnkxui-5"})(['display:flex;&:before{content:"";width:15px;height:15px;margin:auto;border-radius:50%;border:solid 5px transparent;border-top-color:white;animation:'," 500ms linear infinite;}"],je),Ce=o.ZP.div.withConfig({displayName:"styles__VolumeControl",componentId:"sc-1cnkxui-6"})(["display:flex;"]),Pe=o.ZP.div.withConfig({displayName:"styles__VolumeProgress",componentId:"sc-1cnkxui-7"})(["width:75px;margin:auto 0;"]),Ie=o.ZP.h3.withConfig({displayName:"styles__AudioTitle",componentId:"sc-1cnkxui-8"})(["white-space:nowrap;overflow-x:hidden;text-overflow:ellipsis;text-align:center;width:100%;margin:auto 15px;"]),Ne=o.ZP.div.withConfig({displayName:"styles__AudioDurationContent",componentId:"sc-1cnkxui-9"})(["display:flex;flex-direction:column;"]),Ze=o.ZP.p.withConfig({displayName:"styles__AudioDurationCount",componentId:"sc-1cnkxui-10"})(["color:white;font-size:10pt;margin:0 15px;text-align:right;"]),Se=o.ZP.div.withConfig({displayName:"styles__AudioProgress",componentId:"sc-1cnkxui-11"})(["margin:auto 10px;"]),Le=o.ZP.div.withConfig({displayName:"PlayList__PlayListContent",componentId:"sc-1p83xcd-0"})(["background-color:#0B4F75;box-shadow:0 5px 5px 0 rgba(0,0,0,0.25);display:flex;flex-direction:column;height:200px;margin-top:20px;margin-bottom:-10px;padding-bottom:15px;border-radius:15px 15px 0 0;overflow-y:hidden;transition:height 500ms;"]),Fe=o.ZP.div.withConfig({displayName:"PlayList__PlaylistHeader",componentId:"sc-1p83xcd-1"})(["padding:10px;text-align:center;border-radius:15px 15px 0 0;background-color:rgba(0,0,0,0.2);overflow-y:hidden;"]),ze=o.ZP.div.withConfig({displayName:"PlayList__MusicCol",componentId:"sc-1p83xcd-2"})(["display:flex;flex-direction:column;overflow-y:scroll;height:100%;"]),Re=o.ZP.div.withConfig({displayName:"PlayList__MusicRow",componentId:"sc-1p83xcd-3"})(["display:flex;& p{display:block;background-color:transparent;border:none;color:white;font-weight:600;white-space:nowrap;overflow-x:hidden;text-overflow:ellipsis;font-size:11pt;padding:5px;cursor:pointer;&:hover{text-decoration:underline;}}"]);function Te(e){var n=(0,_.useState)(null),t=n[0],o=n[1];return(0,_.useEffect)((function(){o(e.playing)}),[e.playing]),(0,r.jsxs)(Le,{style:e.open?{}:{height:0,padding:0},children:[(0,r.jsx)(Fe,{children:(0,r.jsx)("h3",{children:"Lista de m\xfasicas"})}),(0,r.jsx)(ze,{children:e.playlist.map((function(n,o){return(0,r.jsxs)(Re,{onClick:function(){return function(n){e.onClick&&e.onClick(n)}(o)},children:[(0,r.jsxs)("p",{children:[o+1,". ",n]}),null!=t&&o==t&&(0,r.jsx)(A.G,{icon:M.ihg,style:{margin:"auto 5px auto auto"}})]},o)}))})]})}function Ee(e){var n=e.playlist,t=(0,_.useState)(e.src),o=t[0],i=t[1],a=(0,_.useState)(!0),s=a[0],c=a[1],l=(0,_.useState)(!1),d=l[0],u=l[1],p=(0,_.useState)(0),f=p[0],g=p[1],h=(0,_.useState)(0),m=h[0],x=h[1],v=(0,_.useState)("00:00"),w=v[0],y=v[1],b=(0,_.useState)("00:00"),j=b[0],k=b[1],C=(0,_.useState)(!1),P=C[0],I=C[1],N=(0,_.useRef)();(0,_.useEffect)((function(){c(!0),i(e.src)}),[e.src]);var Z=ue(o);function S(){u(!N.current.paused)}function L(){c(!0);var e=n.indexOf(o);e<0||e+1>=n.length?i(n[0]):i(n[e+1])}function F(){if(N.current.currentTime>1)N.current.currentTime=0;else{c(!0);var e=n.indexOf(o);i(e<=0?n[n.length-1]:n[e-1])}}return(0,r.jsxs)(ve,{children:[(0,r.jsx)(Te,{open:P,playlist:n.map((function(e){return ue(e)})),playing:o?n.indexOf(o):null,onClick:function(e){var t=n[e];i(t)}}),(0,r.jsxs)(we,{children:[(0,r.jsx)(ye,{children:(0,r.jsx)(_e,{style:{height:"16px",display:"flex",marginLeft:"auto",padding:"5px"},onClick:function(){I(!P)},children:(0,r.jsx)(A.G,{icon:M.onQ,style:{fontSize:"16pt",margin:"auto"}})})}),(0,r.jsxs)(be,{children:[(0,r.jsx)(_e,{onClick:F,disabled:n.length<=0,children:(0,r.jsx)(A.G,{icon:M.J0P})}),(0,r.jsx)(_e,{onClick:function(){d?N.current.pause():N.current.play()},children:s?(0,r.jsx)(ke,{}):(0,r.jsx)(A.G,{icon:d?M.XQY:M.zc})}),(0,r.jsx)(_e,{onClick:L,disabled:n.length<=0,children:(0,r.jsx)(A.G,{icon:M.Jwg})}),(0,r.jsxs)(Ce,{children:[(0,r.jsx)(_e,{style:{display:"flex"},children:(0,r.jsx)(A.G,{icon:M.ihg,style:{fontSize:"16pt"}})}),(0,r.jsx)(Pe,{children:(0,r.jsx)(de,{percent:m,onInput:function(e){return N.current.volume=e/100,localStorage.setItem("audio_volume",N.current.volume.toString()),x(e),!0},live:!0})})]}),(0,r.jsx)(Ie,{children:Z})]}),(0,r.jsxs)(Ne,{children:[(0,r.jsxs)(Ze,{children:[j,"/",w]}),(0,r.jsx)(Se,{children:(0,r.jsx)(de,{percent:f,follower:!0,onInput:function(e){return N.current.currentTime=N.current.duration/100*e,g(e),!0}})})]}),(0,r.jsx)("audio",{autoPlay:!0,src:o,onPlay:S,onPause:S,onCanPlay:function(){s&&(navigator.mediaSession.metadata=new MediaMetadata({title:Z}),navigator.mediaSession.setActionHandler("previoustrack",F),navigator.mediaSession.setActionHandler("nexttrack",L),N.current.volume=localStorage.getItem("audio_volume")?Number(localStorage.getItem("audio_volume")):.5,c(!1),x(100*N.current.volume),y(pe(N.current.duration)))},onTimeUpdate:function(){var e=100*N.current.currentTime/N.current.duration;g(e),k(pe(N.current.currentTime))},onEnded:L,ref:N})]})]})}var Ae=o.ZP.div.withConfig({displayName:"pages__Container",componentId:"sc-keronp-0"})(['display:grid;grid-template-columns:220px auto;grid-template-rows:64px auto;grid-template-areas:"h n" "m a";height:100vh;transition:grid-template-columns .2s;@media(max-width:950px){grid-template-columns:0 auto}']),Me=o.ZP.header.withConfig({displayName:"pages__Header",componentId:"sc-keronp-1"})(["grid-area:h;display:flex;overflow:hidden;background:rgba(0,0,0,0.5);& .title{margin:auto;}"]),Ve=o.ZP.button.withConfig({displayName:"pages__CollapseButtom",componentId:"sc-keronp-2"})(["display:none;color:white;background-color:transparent;border:none;font-size:15pt;margin:auto 20px;cursor:pointer;&:hover{color:#dddddd;}@media(max-width:950px){display:block;}"]),Be=o.ZP.nav.withConfig({displayName:"pages__Nav",componentId:"sc-keronp-3"})(["grid-area:n;display:flex;background:rgba(0,0,0,0.5);overflow-x:scroll;white-space:nowrap;"]),Ue=o.ZP.main.withConfig({displayName:"pages__Main",componentId:"sc-keronp-4"})(["grid-area:m;overflow-y:scroll;background:rgba(0,0,0,0.5);"]),Ge=o.ZP.aside.withConfig({displayName:"pages__Aside",componentId:"sc-keronp-5"})(["grid-area:a;overflow-y:scroll;background:rgba(9,9,9,0.3);"]),Oe=o.ZP.div.withConfig({displayName:"pages__PathLink",componentId:"sc-keronp-6"})(["font-size:11pt;font-weight:bold;margin:auto 25px;color:white;& a{color:white;margin:0 2px;padding:2px;border-radius:5px;&:hover{background-color:rgba(255,255,255,0.3);}}"]);function Ye(){var e=new me,n=(0,_.useState)([]),t=n[0],o=n[1],i=(0,_.useState)(null),a=i[0],s=i[1],c=(0,_.useState)(!1),l=c[0],d=c[1],u=(0,_.useState)(),p=u[0],f=u[1],g=(0,_.useState)(),h=g[0],m=g[1],v=(0,_.useState)(),w=v[0],y=v[1],j=(0,_.useState)([]),k=j[0],C=j[1],P=(0,_.useState)(!1),I=P[0],N=P[1],Z=(0,_.useState)(null),S=Z[0],L=Z[1];function F(){d(!1),e.getFiles(null,(function(e){o(e.filter((function(e){return e.is_dir})).map((function(e){return e.href="#/".concat(e.name),e}))),z()}),(function(e,n){if(401==e)return d(!0);f(n)}))}function z(){var n=arguments.length>0&&void 0!==arguments[0]?arguments[0]:location.hash.substring(1),t=arguments.length>1&&void 0!==arguments[1]?arguments[1]:null;s(null),f(null),e.getFiles(n,(function(n,o){if(1==n.length&&n[0].open){var i=e.openFile(n[0],o);z(i.parent,(function(e){return R(i,e)}))}else{L(o);var r=n.map((function(e){return e.href=o?"#/".concat(o,"/").concat(e.name):"#/".concat(e.name),e}));s(r),t&&t(r)}}),(function(e,n){if(401==e)return d(!0);f(n)}))}function R(n,t){if(y(null),m(null),n.type){if(n.type.match(/video\/(mp4|webm|ogg|mkv)/))return void m(n);if(n.type.match(/audio\/(mpeg|mp3|ogg|(x-(pn-)?)?wav)/))return y(n),void C(t?t.filter((function(e){var n;return null===(n=e.type)||void 0===n?void 0:n.match(/audio\/(mpeg|mp3|ogg|(x-(pn-)?)?wav)/)})).map((function(t){return e.getFileSrc("".concat(n.parent,"/").concat(t.name))})):[])}location.href=n.src}return(0,_.useEffect)((function(){window.onhashchange=function(){m(null),z()},F()}),[]),(0,r.jsxs)(Ae,{style:{gridTemplateColumns:I?"220px auto":null},children:[(0,r.jsx)(Me,{children:(0,r.jsx)("h2",{className:"title",children:(0,r.jsx)("a",{href:"#",children:"RaspAdmin"})})}),(0,r.jsxs)(Be,{children:[(0,r.jsx)(Ve,{onClick:function(){N(!I)},children:(0,r.jsx)(A.G,{icon:M.xiG})}),(0,r.jsxs)(Oe,{children:["/",(0,r.jsx)("a",{href:"#/",children:"home"}),S&&S.split("/").map((function(e,n){var t="";return S.split("/").forEach((function(e,o){o<=n&&(t+="/".concat(e))})),(0,r.jsxs)(r.Fragment,{children:["/",(0,r.jsx)("a",{href:"#".concat(t),children:e},n)]})}))]})]}),(0,r.jsx)(Ue,{children:(0,r.jsx)(b,{files:t.filter((function(e){return e.is_dir}))})}),(0,r.jsx)(Ge,{children:(0,r.jsx)(x,{files:a,text:p})}),h&&(0,r.jsx)(ge,{src:h.src,backUrl:"#".concat(h.parent)}),w&&(0,r.jsx)(Ee,{src:w.src,playlist:k}),l&&(0,r.jsx)(E,{onSuccess:F})]})}},8312:function(e,n,t){(window.__NEXT_P=window.__NEXT_P||[]).push(["/",function(){return t(8779)}])}},function(e){e.O(0,[976,75,774,888,179],(function(){return n=8312,e(e.s=n);var n}));var n=e.O();_N_E=n}]);