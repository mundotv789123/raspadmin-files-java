(self.webpackChunk_N_E=self.webpackChunk_N_E||[]).push([[405],{7025:function(e,n,t){"use strict";t.r(n),t.d(n,{default:function(){return ve}});var o=t(9521),r=t(2640),i=t(5893),a=function(e){if(e.is_dir)return"folder.png";if(!e.type)return"document.png";var n=e.type.toString().split("/"),t=(0,r.Z)(n,2),o=t[0],i=t[1];switch(o){case"video":return"video.png";case"audio":return"music.png";case"image":return"image.png";case"application":switch(i){case"java-archive":return"java.png";case"x-msdos-program":return"exe.png";case"x-iso9660-image":case"octet-stream":return"iso.png";case"x-msdownload":case"x-sh":return"document.png"}return"compact.png";case"text":return"x-java-source"===i?"java.png":"document.png"}return"document.png"},s=o.ZP.a.withConfig({displayName:"FileBlock__FileCont",componentId:"sc-180mzed-0"})(["height:130px;margin:5px;text-align:center;overflow:hidden;font-weight:600;word-wrap:break-word;transition:background-color 0.5s;border-radius:5px;&:hover{background:rgba(255,255,255,0.3);overflow:inherit;z-index:1;transition:background-color 0.1s;}"]),c=o.ZP.div.withConfig({displayName:"FileBlock__FileIcon",componentId:"sc-180mzed-1"})(["width:80px;height:80px;margin:5px auto;border-radius:5px;background-size:cover;background-position:center;"]),l=o.ZP.p.withConfig({displayName:"FileBlock__Name",componentId:"sc-180mzed-2"})(["text-align:center;font-weight:bold;"]);function d(e){return(0,i.jsxs)(s,{href:e.file.href,children:[(0,i.jsx)(c,{style:{backgroundImage:"url('"+(e.file.icon?e.file.icon:"/img/icons/"+a(e.file))+"')"}}),(0,i.jsx)(l,{children:e.file.name})]})}var u=(0,o.F4)(["0%{margin-left:0;width:0;}50%{margin-left:0;width:100%;}100%{margin-left:100%;width:0;}"]),p=o.ZP.div.withConfig({displayName:"Loading__LoadingCont",componentId:"sc-4z1qry-0"})(["width:100%;"]),f=o.ZP.div.withConfig({displayName:"Loading__LoadingBar",componentId:"sc-4z1qry-1"})(["height:10px;background-color:white;animation:"," 1s ease infinite;"],u);function g(){return(0,i.jsx)(p,{children:(0,i.jsx)(f,{})})}var h=o.ZP.div.withConfig({displayName:"FilesBlocks__Panel",componentId:"sc-vrga00-0"})(["display:flex;flex-wrap:wrap;flex-direction:row;padding:10px;text-align:center;align-content:start;& a{width:calc(20% - 10px);}@media(min-width:1400px){& a{width:calc(14.2% - 10px);}}@media(max-width:680px){& a{width:calc(50% - 10px);}}"]),m=o.ZP.h1.withConfig({displayName:"FilesBlocks__Text",componentId:"sc-vrga00-1"})(["color:white;text-align:center;width:100%;"]);function x(e){if(e.text)return(0,i.jsx)(h,{children:(0,i.jsx)(m,{children:e.text})});if(null===e.files)return(0,i.jsx)(h,{children:(0,i.jsx)(g,{})});if(0==e.files.length)return(0,i.jsx)(h,{children:(0,i.jsx)(m,{children:"Essa pasta est\xe1 vazia!"})});var n=0;return(0,i.jsx)(h,{children:e.files.map((function(e){return(0,i.jsx)(d,{file:e},n++)}))})}var w=o.ZP.a.withConfig({displayName:"FileRow__Row",componentId:"sc-rb7ntb-0"})(["padding:12px;font-weight:600;white-space:nowrap;overflow-x:hidden;text-overflow:ellipsis;&:hover{background:rgba(255,255,255,0.3);}"]);function v(e){var n=e.src.split("/"),t=n[n.length-1];return(0,i.jsx)(w,{href:e.src,children:t})}var y=o.ZP.div.withConfig({displayName:"FilesList__Column",componentId:"sc-km3ln0-0"})(["display:flex;flex-direction:column;"]);function b(e){if(e.files){var n=0;return(0,i.jsx)(y,{children:e.files.map((function(e){return(0,i.jsx)(v,{src:e.href},++n)}))})}return(0,i.jsx)(y,{})}var _=t(7294),k=t(2777),j=t(2262),C=t(9499),P=t(9669),N=t.n(P),Z=function(){function e(){var n;(0,k.Z)(this,e),(0,C.Z)(this,"API_URL",null!==(n="/api")?n:"/api"),(0,C.Z)(this,"api",void 0),this.api=N().create({baseURL:"".concat(this.API_URL,"/auth"),timeout:5e3})}return(0,j.Z)(e,[{key:"login",value:function(e,n,t,o){var r=new URLSearchParams;r.append("username",e),r.append("password",n),this.api.post("/login",r,{auth:{username:e,password:n}}).then(t).catch((function(e){if(o){var n="Erro interno ao processar requisi\xe7\xe3o";try{var t=JSON.parse(e.request.response);t.message&&(n=t.message)}catch(r){}o(n)}}))}}]),e}(),I=o.ZP.div.withConfig({displayName:"LoginMenu__LoginCont",componentId:"sc-7cctlv-0"})(["display:flex;position:fixed;top:0;left:0;right:0;bottom:0;background:rgba(9,9,9,1);"]),S=(0,o.F4)(["0%{opacity:0;transform:translateY(-500px);}90%{opacity:100;transform:translateY(5px);}100%{opacity:100;transform:translateY(0);}"]),L=o.ZP.form.withConfig({displayName:"LoginMenu__LoginForm",componentId:"sc-7cctlv-1"})(["margin:auto;background:rgb(48,48,48);padding:15px 25px;display:block;border-radius:10px;animation:"," 0.8s normal;"],S),R=o.ZP.h2.withConfig({displayName:"LoginMenu__Title",componentId:"sc-7cctlv-2"})(["text-align:center;margin:15px 0;"]),z=o.ZP.input.withConfig({displayName:"LoginMenu__Input",componentId:"sc-7cctlv-3"})(["display:block;background:rgb(50,50,50);border:solid 1px gray;margin:10px auto;padding:5px;color:white;text-align:center;border-radius:5px;&:focus{border:solid 1px white;outline:none;}"]),F=o.ZP.div.withConfig({displayName:"LoginMenu__ErrorArea",componentId:"sc-7cctlv-4"})(["background-color:red;text-align:center;width:220px;border-radius:5px;padding:3px;transition:0.5s;& p{font-size:10pt;}"]),T=o.ZP.button.withConfig({displayName:"LoginMenu__Button",componentId:"sc-7cctlv-5"})(["display:block;background:rgb(50,50,50);border:solid 1px gray;margin:5px auto;padding:7px;color:white;&:focus{outline:none;}&:hover{background:rgb(80,80,80);}&:active{border:solid 1px white;}"]);function E(e){var n=new Z,t=(0,_.useState)(),o=t[0],r=t[1];return(0,i.jsx)(I,{children:(0,i.jsxs)(L,{onSubmit:function(t){t.preventDefault();var o=t.target.username.value,i=t.target.password.value;""!==o&&""!==i?n.login(o,i,e.onSuccess,(function(e){r(e)})):r("Preencha todos os campos")},children:[(0,i.jsx)(R,{children:"Login"}),(0,i.jsx)(z,{placeholder:"Username",id:"username",required:!0}),(0,i.jsx)(z,{placeholder:"Password",id:"password",type:"password",required:!0}),o&&(0,i.jsx)(F,{children:(0,i.jsx)("p",{children:o})}),(0,i.jsx)(T,{children:"Login"})]})})}var V=t(9603),B=t(9417),U=o.ZP.div.withConfig({displayName:"styles__VideoCont",componentId:"sc-1we10of-0"})(["display:flex;background-color:black;color:white;overflow:hidden;position:fixed;top:0;bottom:0;left:0;right:0;& .hide{transition:0.5s;opacity:0;cursor:none;}"]),A=o.ZP.video.withConfig({displayName:"styles__VideoElement",componentId:"sc-1we10of-1"})(["width:100%;height:100%;margin:auto;"]),M=o.ZP.div.withConfig({displayName:"styles__VideoMain",componentId:"sc-1we10of-2"})(["top:0;bottom:0;left:0;right:0;position:absolute;display:flex;flex-direction:column;"]),q=o.ZP.div.withConfig({displayName:"styles__VideoTop",componentId:"sc-1we10of-3"})(["color:white;padding:15px;background-image:linear-gradient(to bottom,rgba(0,0,0,0.8),transparent);user-select:none;"]),G=o.ZP.h2.withConfig({displayName:"styles__VideoTitle",componentId:"sc-1we10of-4"})(["text-align:center;margin:0 60px;white-space:nowrap;overflow-x:hidden;text-overflow:ellipsis;"]),O=o.ZP.div.withConfig({displayName:"styles__VideoCenter",componentId:"sc-1we10of-5"})(["height:100%;display:flex;"]),Y=(0,o.F4)(["to{transform:rotate(0);}from{transform:rotate(-360deg);}"]),X=o.ZP.div.withConfig({displayName:"styles__VideoLoading",componentId:"sc-1we10of-6"})(["margin:auto;border-radius:50%;width:120px;height:120px;border:solid 10px transparent;border-left-color:white;animation:"," 0.7s linear infinite;"],Y),J=o.ZP.div.withConfig({displayName:"styles__VideoBottom",componentId:"sc-1we10of-7"})(["padding:10px;display:flex;background-image:linear-gradient(to bottom,transparent,rgba(0,0,0,0.8));"]),$=o.ZP.button.withConfig({displayName:"styles__VideoButton",componentId:"sc-1we10of-8"})(["background-color:transparent;border:none;color:white;font-size:13pt;margin:0 5px;font-size:20px;text-align:center;width:28px;&:hover{color:lightgray;transform:translateY(-1px);}"]),H=o.ZP.div.withConfig({displayName:"styles__CenterButtons",componentId:"sc-1we10of-9"})(["margin:auto;display:flex;& button{color:white;background-color:rgba(0,0,0,0.5);border:none;border-radius:50%;transition:0.1s;margin:auto 10px;&:hover{transform:translateY(-1px);box-shadow:0 2px 5px 1px black;}}& .buttonBig{font-size:50px;width:100px;height:100px;&:hover{font-size:52px;}}& .buttonSmall{width:50px;height:50px;font-size:25px;&:hover{font-size:26px;}}"]),Q=o.ZP.a.withConfig({displayName:"styles__VideoCloseButton",componentId:"sc-1we10of-10"})(["background-color:transparent;border:none;color:white;font-size:13pt;font-size:20px;text-align:center;position:absolute;top:0;left:0;margin:10px 15px;&:hover{color:lightgray;transform:translateY(-1px);}"]),D=o.ZP.div.withConfig({displayName:"styles__VideoProgress",componentId:"sc-1we10of-11"})(["width:100%;padding:2px 0;display:flex;cursor:pointer;& .background{width:100%;margin:auto 5px;background:rgb(100,100,100);height:7px;border-radius:5px;display:flex;}&:hover .follower{opacity:100;}"]),K=o.ZP.div.withConfig({displayName:"styles__VideoProgressBar",componentId:"sc-1we10of-12"})(['background-color:white;height:100%;border-radius:5px 0 0 5px;display:flex;z-index:1;&::after{content:"";display:block;border:solid 7px white;top:-3px;margin-right:-5px;margin-left:auto;position:relative;border-radius:50%;}']),W=o.ZP.div.withConfig({displayName:"styles__VideoProgressFollower",componentId:"sc-1we10of-13"})(["border-radius:5px 0px 0px 5px;height:100%;width:50%;background-color:gray;display:flex;opacity:0;"]),ee=o.ZP.div.withConfig({displayName:"styles__VideoVolume",componentId:"sc-1we10of-14"})(["border-radius:10px;overflow:show;display:flex;flex-direction:column;transition:320ms;& .volume{height:100%;width:10px;background-color:#999;margin:0 auto;border-radius:15px;overflow:hidden;display:flex;flex-direction:column;cursor:pointer;}& .volume .volume_percent{width:100%;margin-top:auto;background-color:white;transition:all 0.2s ease 0s;}&:hover{background-color:#444;padding:10px 0 5px 0;margin-top:-105px;}& button{margin:0 !important;}"]),ne=o.ZP.h1.withConfig({displayName:"styles__Error",componentId:"sc-1we10of-15"})(["margin:auto;color:#ff5b5b;"]),te=t(29),oe=t(7794),re=t.n(oe),ie=t(2568),ae=t.n(ie),se=function(){function e(){(0,k.Z)(this,e)}return(0,j.Z)(e,[{key:"setVideoTime",value:function(e,n){if(!(n<=0)){var t=localStorage.videos?JSON.parse(localStorage.videos):{};t[ae()(e)]=n,localStorage.videos=JSON.stringify(t)}}},{key:"getVideoTime",value:function(e){if(!localStorage.videos)return localStorage.videos=JSON.stringify({}),0;var n=JSON.parse(localStorage.videos),t=ae()(e);return n[t]?n[t]:0}},{key:"startAutoSaving",value:function(){var e=(0,te.Z)(re().mark((function e(n,t){var o=this;return re().wrap((function(e){for(;;)switch(e.prev=e.next){case 0:if(t&&t.src){e.next=2;break}return e.abrupt("return");case 2:this.setVideoTime(n,t.currentTime),setTimeout((function(){o.startAutoSaving(n,t)}),1e3);case 4:case"end":return e.stop()}}),e,this)})));return function(n,t){return e.apply(this,arguments)}}()}]),e}(),ce=0;function le(e){var n=(0,_.useState)(0),t=n[0],o=n[1],r=(0,_.useState)(0),a=r[0],s=r[1],c=(0,_.useState)(!0),l=c[0],d=c[1],u=(0,_.useState)(!1),p=u[0],f=u[1],g=(0,_.useState)(null),h=g[0],m=g[1],x=(0,_.useRef)(null),w=(0,_.useRef)(null),v=(0,_.useRef)(null),y=(0,_.useRef)(null),b=(0,_.useRef)(null),k=(0,_.useRef)(null),j=(0,_.useRef)(null),C=new se;function P(){w.current.classList&&w.current.classList.remove("hide"),ce<=0&&N(),ce=3}function N(){setTimeout((function(){--ce>0?N():w.current&&!j.current.paused&&w.current.classList.add("hide")}),1e3)}function Z(){l||h||(P(),p?j.current.pause():j.current.play(),m(!1),d(!1))}function I(){f(!j.current.paused)}if(null==e.src)return(0,i.jsx)(i.Fragment,{});var S=decodeURIComponent(e.src).replace(/\/+$/,"").replace(/^([a-zA-Z]+:\/\/)?\/?([^\/]+\/)+/,"").replace(/\.[a-zA-Z0-9]+$/,"");return(0,i.jsxs)(U,{ref:x,onMouseMove:P,children:[(0,i.jsx)(A,{onPlay:I,onPause:I,onTimeUpdate:function(){var e=100*j.current.currentTime/j.current.duration;o(e)},onError:function(){d(!1),m(j.current.error.message)},onCanPlay:function(){if(l){k.current.style.height=100*j.current.volume+"%";var e=C.getVideoTime(j.current.src);e>0&&j.current.duration-15>e&&(j.current.currentTime=e),d(!1),C.startAutoSaving(j.current.src,j.current)}},src:e.src,autoPlay:!0,controls:!1,ref:j}),(0,i.jsxs)(M,{ref:w,children:[(0,i.jsxs)(q,{children:[(0,i.jsx)(G,{children:S}),(0,i.jsx)(Q,{style:{display:e.backUrl?"":"none"},href:e.backUrl,onClick:function(){j.current.src=null,f(!1),o(0),d(!0)},children:(0,i.jsx)(V.G,{icon:B.EyR})})]}),(0,i.jsxs)(O,{children:[l&&(0,i.jsx)(X,{}),h&&(0,i.jsx)(ne,{children:"Erro ao carregar v\xeddeo"}),!l&&!h&&(0,i.jsxs)(H,{children:[(0,i.jsx)("button",{className:"buttonSmall",onClick:function(){j.current.currentTime-=5},children:(0,i.jsx)(V.G,{icon:B.XnX})}),(0,i.jsx)("button",{className:"buttonBig",onClick:Z,children:(0,i.jsx)(V.G,{icon:p?B.XQY:B.zc})}),(0,i.jsx)("button",{className:"buttonSmall",onClick:function(){j.current.currentTime+=5},children:(0,i.jsx)(V.G,{icon:B.mHK})})]})]}),(0,i.jsxs)(J,{children:[(0,i.jsx)($,{onClick:Z,children:(0,i.jsx)(V.G,{icon:p?B.XQY:B.zc})}),(0,i.jsx)(D,{onClick:function(e){if(!l&&!h){var n=y.current.getBoundingClientRect(),t=100*(e.clientX-n.left)/(n.right-n.left);j.current.currentTime=j.current.duration/100*t,o(t)}},onMouseMove:function(e){var n=y.current.getBoundingClientRect(),t=100*(e.clientX-n.left)/(n.right-n.left);s(t)},ref:y,children:(0,i.jsxs)("div",{className:"background",children:[(0,i.jsx)(K,{style:{width:"".concat(t,"%")}}),(0,i.jsx)(W,{className:"follower",style:{marginLeft:"-".concat(t,"%"),width:"".concat(a,"%")},ref:v})]})}),(0,i.jsxs)(ee,{children:[(0,i.jsx)("div",{className:"volume",ref:b,onClick:function(e){var n=b.current.getBoundingClientRect(),t=1*(n.bottom-e.clientY)/(n.bottom-n.top);j.current.volume=t,k.current.style.height=100*t+"%"},children:(0,i.jsx)("div",{className:"volume_percent",ref:k})}),(0,i.jsx)($,{children:(0,i.jsx)(V.G,{icon:B.ihg})})]}),(0,i.jsx)($,{onClick:function(){document.fullscreenElement?(document.exitFullscreen(),screen.orientation.unlock()):(x.current.requestFullscreen(),screen.orientation.lock("landscape"))},children:(0,i.jsx)(V.G,{icon:B.TL5})})]})]})]})}var de=t(983),ue=function(){function e(){var n;(0,k.Z)(this,e),(0,C.Z)(this,"API_URL",null!==(n="/api")?n:"/api"),(0,C.Z)(this,"api",void 0),this.api=N().create({baseURL:"".concat(this.API_URL),timeout:5e3})}return(0,j.Z)(e,[{key:"getFiles",value:function(e,n,t){var o=this,r=this.clearPath(e);this.api.get("/files",{params:{path:"/".concat(r)}}).then((function(e){if(204==e.status)return n([],r);var t=Object.values(e.data.files).map((function(e){if(!e.type){var n=(0,de.lookup)(e.name);n&&(e.type=n)}return e.icon&&(e.icon="".concat(o.API_URL,"/files/open?path=/").concat(encodeURIComponent(e.icon))),e}));t=t.sort((function(e,n){return(""+e.name).localeCompare(n.name,void 0,{numeric:!0})})),n(t,r)})).catch((function(e){if(t){var n=500;try{var r=e.toJSON();r&&r.status&&(n=r.status)}catch(a){}var i=o.getErrorMessage(n);t(n,i)}}))}},{key:"openFile",value:function(e,n){var t=n.replace(/\/[^\/]+\/?$/,"");return{name:e.name,type:e.type,parent:t,src:"".concat(this.API_URL,"/files/open?path=/").concat(encodeURIComponent(n))}}},{key:"clearPath",value:function(e){return null==e?"":decodeURI(e.replace(/\/\/+/,"/").replace(/^\/+/,"").replace(/\/+$/,"").trim())}},{key:"getErrorMessage",value:function(e){switch(e){case 404:return"Arquivo ou diret\xf3rio n\xe3o encontrado!";case 403:return"Voc\xea n\xe3o tem permiss\xe3o para acessar esse arquivo ou diret\xf3rio!";case 500:return"Erro interno ao processar arquivo!";default:return"Erro desconhecido ao processar requisi\xe7\xe3o!"}}}]),e}(),pe=o.ZP.div.withConfig({displayName:"pages__Container",componentId:"sc-keronp-0"})(['display:grid;grid-template-columns:220px auto;grid-template-rows:64px auto;grid-template-areas:"h n" "m a";height:100vh;transition:grid-template-columns .2s;@media(max-width:950px){grid-template-columns:0 auto}']),fe=o.ZP.header.withConfig({displayName:"pages__Header",componentId:"sc-keronp-1"})(["grid-area:h;display:flex;overflow:hidden;background:rgba(0,0,0,0.5);& .title{margin:auto;}"]),ge=o.ZP.button.withConfig({displayName:"pages__CollapseButtom",componentId:"sc-keronp-2"})(["display:none;color:white;background-color:transparent;border:none;font-size:15pt;margin:auto 20px;cursor:pointer;&:hover{color:#dddddd;}@media(max-width:950px){display:block;}"]),he=o.ZP.nav.withConfig({displayName:"pages__Nav",componentId:"sc-keronp-3"})(["grid-area:n;display:flex;background:rgba(0,0,0,0.5);overflow-x:scroll;white-space:nowrap;"]),me=o.ZP.main.withConfig({displayName:"pages__Main",componentId:"sc-keronp-4"})(["grid-area:m;overflow-y:scroll;background:rgba(0,0,0,0.5);"]),xe=o.ZP.aside.withConfig({displayName:"pages__Aside",componentId:"sc-keronp-5"})(["grid-area:a;overflow-y:scroll;background:rgba(9,9,9,0.3);"]),we=o.ZP.div.withConfig({displayName:"pages__PathLink",componentId:"sc-keronp-6"})(["font-size:11pt;font-weight:bold;margin:auto 25px;color:white;& a{color:white;margin:0 2px;padding:2px;border-radius:5px;&:hover{background-color:rgba(255,255,255,0.3);}}"]);function ve(){var e=new ue,n=(0,_.useState)([]),t=n[0],o=n[1],r=(0,_.useState)(null),a=r[0],s=r[1],c=(0,_.useState)(!1),l=c[0],d=c[1],u=(0,_.useState)(),p=u[0],f=u[1],g=(0,_.useState)(),h=g[0],m=g[1],w=(0,_.useState)(!1),v=w[0],y=w[1],k=(0,_.useState)(null),j=k[0],C=k[1];function P(){d(!1),e.getFiles(null,(function(e){o(e.filter((function(e){return e.is_dir})).map((function(e){return e.href="#/".concat(e.name),e}))),N()}),(function(e,n){if(401==e)return d(!0);f(n)}))}function N(){var n=arguments.length>0&&void 0!==arguments[0]?arguments[0]:location.hash.substring(1);s(null),f(null),e.getFiles(n,(function(n,t){if(1==n.length&&n[0].open){var o=e.openFile(n[0],t);return Z(o),void N(o.parent)}C(t),s(n.map((function(e){return e.href=t?"#/".concat(t,"/").concat(e.name):"#/".concat(e.name),e})))}),(function(e,n){if(401==e)return d(!0);f(n)}))}function Z(e){e.type&&e.type.match(/video\/(mp4|webm|ogg|mkv)/)?m(e):location.href=e.src}return(0,_.useEffect)((function(){window.onhashchange=function(){m(null),N()},P()}),[]),(0,i.jsxs)(pe,{style:{gridTemplateColumns:v?"220px auto":null},children:[(0,i.jsx)(fe,{children:(0,i.jsx)("h2",{className:"title",children:(0,i.jsx)("a",{href:"#",children:"RaspAdmin"})})}),(0,i.jsxs)(he,{children:[(0,i.jsx)(ge,{onClick:function(){y(!v)},children:(0,i.jsx)(V.G,{icon:B.xiG})}),(0,i.jsxs)(we,{children:["/",(0,i.jsx)("a",{href:"#/",children:"home"}),j&&j.split("/").map((function(e,n){var t="";return j.split("/").forEach((function(e,o){o<=n&&(t+="/".concat(e))})),(0,i.jsxs)(i.Fragment,{children:["/",(0,i.jsx)("a",{href:"#".concat(t),children:e})]})}))]})]}),(0,i.jsx)(me,{children:(0,i.jsx)(b,{files:t.filter((function(e){return e.is_dir}))})}),(0,i.jsx)(xe,{children:(0,i.jsx)(x,{files:a,text:p})}),h&&(0,i.jsx)(le,{src:h.src,backUrl:"#".concat(h.parent)}),l&&(0,i.jsx)(E,{onSuccess:P})]})}},8312:function(e,n,t){(window.__NEXT_P=window.__NEXT_P||[]).push(["/",function(){return t(7025)}])}},function(e){e.O(0,[976,75,774,888,179],(function(){return n=8312,e(e.s=n);var n}));var n=e.O();_N_E=n}]);