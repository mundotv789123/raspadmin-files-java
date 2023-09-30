(self.webpackChunk_N_E=self.webpackChunk_N_E||[]).push([[405],{8586:function(e,n,t){"use strict";t.r(n),t.d(n,{default:function(){return Me}});var i=t(9521),o=t(2640),r=t(5893),a=function(e){if(e.is_dir)return"folder.png";if(!e.type)return"document.png";var n=e.type.toString().split("/"),t=(0,o.Z)(n,2),i=t[0],r=t[1];switch(i){case"video":return"video.png";case"audio":return"music.png";case"image":return"image.png";case"application":switch(r){case"java-archive":return"java.png";case"x-msdos-program":return"exe.png";case"x-iso9660-image":case"octet-stream":return"iso.png";case"x-msdownload":case"x-sh":return"document.png"}return"compact.png";case"text":return"x-java-source"===r?"java.png":"document.png"}return"document.png"},s=i.ZP.a.withConfig({displayName:"FileBlock__FileCont",componentId:"sc-180mzed-0"})(["height:130px;margin:5px;text-align:center;overflow:hidden;font-weight:600;word-wrap:break-word;transition:background-color 0.5s;border-radius:5px;&:hover{background:rgba(255,255,255,0.3);overflow:inherit;z-index:1;transition:background-color 0.1s;}"]),c=i.ZP.div.withConfig({displayName:"FileBlock__FileIcon",componentId:"sc-180mzed-1"})(["width:80px;height:80px;margin:5px auto;border-radius:5px;background-size:cover;background-position:center;"]),l=i.ZP.p.withConfig({displayName:"FileBlock__Name",componentId:"sc-180mzed-2"})(["text-align:center;font-weight:bold;"]);function d(e){return(0,r.jsxs)(s,{href:e.file.href,children:[(0,r.jsx)(c,{style:{backgroundImage:"url('"+(e.file.icon?e.file.icon:"/img/icons/"+a(e.file))+"')"}}),(0,r.jsx)(l,{children:e.file.name})]})}var u=(0,i.F4)(["0%{margin-left:0;width:0;}50%{margin-left:0;width:100%;}100%{margin-left:100%;width:0;}"]),p=i.ZP.div.withConfig({displayName:"Loading__LoadingCont",componentId:"sc-4z1qry-0"})(["width:100%;"]),g=i.ZP.div.withConfig({displayName:"Loading__LoadingBar",componentId:"sc-4z1qry-1"})(["height:10px;background-color:white;animation:"," 1s ease infinite;"],u);function f(){return(0,r.jsx)(p,{children:(0,r.jsx)(g,{})})}var h=i.ZP.div.withConfig({displayName:"FilesBlocks__Panel",componentId:"sc-vrga00-0"})(["display:flex;flex-wrap:wrap;flex-direction:row;padding:10px;text-align:center;align-content:start;& a{width:calc(20% - 10px);}@media(min-width:1400px){& a{width:calc(14.2% - 10px);}}@media(max-width:680px){& a{width:calc(50% - 10px);}}"]),x=i.ZP.h1.withConfig({displayName:"FilesBlocks__Text",componentId:"sc-vrga00-1"})(["color:white;text-align:center;width:100%;"]);function m(e){if(e.text)return(0,r.jsx)(h,{children:(0,r.jsx)(x,{children:e.text})});if(null===e.files)return(0,r.jsx)(h,{children:(0,r.jsx)(f,{})});if(0==e.files.length)return(0,r.jsx)(h,{children:(0,r.jsx)(x,{children:"Essa pasta est\xe1 vazia!"})});var n=0;return(0,r.jsx)(h,{children:e.files.map((function(e){return(0,r.jsx)(d,{file:e},n++)}))})}var w=i.ZP.a.withConfig({displayName:"FileRow__Row",componentId:"sc-rb7ntb-0"})(["padding:12px;font-weight:600;white-space:nowrap;overflow-x:hidden;text-overflow:ellipsis;&:hover{background:rgba(255,255,255,0.3);}"]);function v(e){var n=e.src.split("/"),t=n[n.length-1];return(0,r.jsx)(w,{href:e.src,children:t})}var y=i.ZP.div.withConfig({displayName:"FilesList__Column",componentId:"sc-km3ln0-0"})(["display:flex;flex-direction:column;"]);function b(e){if(e.files){var n=0;return(0,r.jsx)(y,{children:e.files.map((function(e){return(0,r.jsx)(v,{src:e.href},++n)}))})}return(0,r.jsx)(y,{})}var _=t(7294),k=t(2777),j=t(2262),C=t(9499),P=t(9669),N=t.n(P),I=function(){function e(){var n;(0,k.Z)(this,e),(0,C.Z)(this,"API_URL",null!==(n="/api")?n:"/api"),(0,C.Z)(this,"api",void 0),this.api=N().create({baseURL:"".concat(this.API_URL,"/auth"),timeout:5e3})}return(0,j.Z)(e,[{key:"login",value:function(e,n,t,i){var o=new URLSearchParams;o.append("username",e),o.append("password",n),this.api.post("/login",o,{auth:{username:e,password:n}}).then(t).catch((function(e){if(i){var n="Erro interno ao processar requisi\xe7\xe3o";try{var t=JSON.parse(e.request.response);t.message&&(n=t.message)}catch(o){}i(n)}}))}}]),e}(),Z=i.ZP.div.withConfig({displayName:"LoginMenu__LoginCont",componentId:"sc-7cctlv-0"})(["display:flex;position:fixed;top:0;left:0;right:0;bottom:0;z-index:1;background:rgba(9,9,9,1);"]),S=(0,i.F4)(["0%{opacity:0;transform:translateY(-500px);}90%{opacity:100;transform:translateY(5px);}100%{opacity:100;transform:translateY(0);}"]),L=i.ZP.form.withConfig({displayName:"LoginMenu__LoginForm",componentId:"sc-7cctlv-1"})(["margin:auto;background:rgb(48,48,48);padding:15px 25px;display:block;border-radius:10px;animation:"," 0.8s normal;"],S),F=i.ZP.h2.withConfig({displayName:"LoginMenu__Title",componentId:"sc-7cctlv-2"})(["text-align:center;margin:15px 0;"]),z=i.ZP.input.withConfig({displayName:"LoginMenu__Input",componentId:"sc-7cctlv-3"})(["display:block;background:rgb(50,50,50);border:solid 1px gray;margin:10px auto;padding:5px;color:white;text-align:center;border-radius:5px;&:focus{border:solid 1px white;outline:none;}"]),R=i.ZP.div.withConfig({displayName:"LoginMenu__ErrorArea",componentId:"sc-7cctlv-4"})(["background-color:red;text-align:center;width:220px;border-radius:5px;padding:3px;transition:0.5s;& p{font-size:10pt;}"]),A=i.ZP.button.withConfig({displayName:"LoginMenu__Button",componentId:"sc-7cctlv-5"})(["display:block;background:rgb(50,50,50);border:solid 1px gray;margin:5px auto;padding:7px;color:white;&:focus{outline:none;}&:hover{background:rgb(80,80,80);}&:active{border:solid 1px white;}"]);function T(e){var n=new I,t=(0,_.useState)(),i=t[0],o=t[1];return(0,r.jsx)(Z,{children:(0,r.jsxs)(L,{onSubmit:function(t){t.preventDefault();var i=t.target.username.value,r=t.target.password.value;""!==i&&""!==r?n.login(i,r,e.onSuccess,(function(e){o(e)})):o("Preencha todos os campos")},children:[(0,r.jsx)(F,{children:"Login"}),(0,r.jsx)(z,{placeholder:"Username",id:"username",required:!0}),(0,r.jsx)(z,{placeholder:"Password",id:"password",type:"password",required:!0}),i&&(0,r.jsx)(R,{children:(0,r.jsx)("p",{children:i})}),(0,r.jsx)(A,{children:"Login"})]})})}var B=t(9603),E=t(9417),V=i.ZP.div.withConfig({displayName:"styles__VideoCont",componentId:"sc-1we10of-0"})(["display:flex;background-color:black;color:white;overflow:hidden;position:fixed;top:0;bottom:0;left:0;right:0;& .hide{transition:0.5s;opacity:0;cursor:none;}"]),U=i.ZP.video.withConfig({displayName:"styles__VideoElement",componentId:"sc-1we10of-1"})(["width:100%;height:100%;margin:auto;"]),M=i.ZP.div.withConfig({displayName:"styles__VideoMain",componentId:"sc-1we10of-2"})(["top:0;bottom:0;left:0;right:0;position:absolute;display:flex;flex-direction:column;"]),G=i.ZP.div.withConfig({displayName:"styles__VideoTop",componentId:"sc-1we10of-3"})(["color:white;padding:15px;background-image:linear-gradient(to bottom,rgba(0,0,0,0.8),transparent);user-select:none;"]),O=i.ZP.h2.withConfig({displayName:"styles__VideoTitle",componentId:"sc-1we10of-4"})(["text-align:center;margin:0 60px;white-space:nowrap;overflow-x:hidden;text-overflow:ellipsis;"]),X=i.ZP.div.withConfig({displayName:"styles__VideoCenter",componentId:"sc-1we10of-5"})(["height:100%;display:flex;"]),Y=(0,i.F4)(["to{transform:rotate(0);}from{transform:rotate(-360deg);}"]),q=i.ZP.div.withConfig({displayName:"styles__VideoLoading",componentId:"sc-1we10of-6"})(["margin:auto;border-radius:50%;width:120px;height:120px;border:solid 10px transparent;border-left-color:white;animation:"," 0.7s linear infinite;"],Y),D=i.ZP.div.withConfig({displayName:"styles__VideoBottom",componentId:"sc-1we10of-7"})(["padding:10px;display:flex;background-image:linear-gradient(to bottom,transparent,rgba(0,0,0,0.8));"]),J=i.ZP.button.withConfig({displayName:"styles__VideoButton",componentId:"sc-1we10of-8"})(["background-color:transparent;border:none;color:white;font-size:13pt;margin:0 5px;font-size:20px;text-align:center;width:28px;&:hover{color:lightgray;transform:translateY(-1px);}"]),H=i.ZP.div.withConfig({displayName:"styles__CenterButtons",componentId:"sc-1we10of-9"})(["margin:auto;display:flex;& button{color:white;background-color:rgba(0,0,0,0.5);border:none;border-radius:50%;transition:0.1s;margin:auto 10px;&:hover{transform:translateY(-1px);box-shadow:0 2px 5px 1px black;}}& .buttonBig{font-size:50px;width:100px;height:100px;&:hover{font-size:52px;}}& .buttonSmall{width:50px;height:50px;font-size:25px;&:hover{font-size:26px;}}"]),$=i.ZP.a.withConfig({displayName:"styles__VideoCloseButton",componentId:"sc-1we10of-10"})(["background-color:transparent;border:none;color:white;font-size:13pt;font-size:20px;text-align:center;position:absolute;top:0;left:0;margin:10px 15px;&:hover{color:lightgray;transform:translateY(-1px);}"]),Q=i.ZP.div.withConfig({displayName:"styles__VideoProgress",componentId:"sc-1we10of-11"})(["width:100%;padding:2px 0;display:flex;cursor:pointer;& .background{width:100%;margin:auto 5px;background:rgb(100,100,100);height:7px;border-radius:5px;display:flex;}&:hover .follower{opacity:100;}"]),K=i.ZP.div.withConfig({displayName:"styles__VideoProgressBar",componentId:"sc-1we10of-12"})(['background-color:white;height:100%;border-radius:5px 0 0 5px;display:flex;z-index:1;&::after{content:"";display:block;border:solid 7px white;top:-3px;margin-right:-5px;margin-left:auto;position:relative;border-radius:50%;}']),W=i.ZP.div.withConfig({displayName:"styles__VideoProgressFollower",componentId:"sc-1we10of-13"})(["border-radius:5px 0px 0px 5px;height:100%;width:50%;background-color:gray;display:flex;opacity:0;"]),ee=i.ZP.div.withConfig({displayName:"styles__VideoVolume",componentId:"sc-1we10of-14"})(["border-radius:10px;overflow:show;display:flex;flex-direction:column;transition:320ms;& .volume{height:100%;width:10px;background-color:#999;margin:0 auto;border-radius:15px;overflow:hidden;display:flex;flex-direction:column;cursor:pointer;}& .volume .volume_percent{width:100%;margin-top:auto;background-color:white;transition:all 0.2s ease 0s;}&:hover{background-color:#444;padding:10px 0 5px 0;margin-top:-105px;}& button{margin:0 !important;}"]),ne=i.ZP.h1.withConfig({displayName:"styles__Error",componentId:"sc-1we10of-15"})(["margin:auto;color:#ff5b5b;"]),te=t(29),ie=t(7794),oe=t.n(ie),re=t(2568),ae=t.n(re),se=function(){function e(){(0,k.Z)(this,e)}return(0,j.Z)(e,[{key:"setVideoTime",value:function(e,n){if(!(n<=0)){var t=localStorage.videos?JSON.parse(localStorage.videos):{};t[ae()(e)]=n,localStorage.videos=JSON.stringify(t)}}},{key:"getVideoTime",value:function(e){if(!localStorage.videos)return localStorage.videos=JSON.stringify({}),0;var n=JSON.parse(localStorage.videos),t=ae()(e);return n[t]?n[t]:0}},{key:"startAutoSaving",value:function(){var e=(0,te.Z)(oe().mark((function e(n,t){var i=this;return oe().wrap((function(e){for(;;)switch(e.prev=e.next){case 0:if(t&&t.src){e.next=2;break}return e.abrupt("return");case 2:this.setVideoTime(n,t.currentTime),setTimeout((function(){i.startAutoSaving(n,t)}),1e3);case 4:case"end":return e.stop()}}),e,this)})));return function(n,t){return e.apply(this,arguments)}}()}]),e}(),ce=0;function le(e){var n=(0,_.useState)(0),t=n[0],i=n[1],o=(0,_.useState)(0),a=o[0],s=o[1],c=(0,_.useState)(!0),l=c[0],d=c[1],u=(0,_.useState)(!1),p=u[0],g=u[1],f=(0,_.useState)(null),h=f[0],x=f[1],m=(0,_.useRef)(null),w=(0,_.useRef)(null),v=(0,_.useRef)(null),y=(0,_.useRef)(null),b=(0,_.useRef)(null),k=(0,_.useRef)(null),j=(0,_.useRef)(null),C=new se;function P(){w.current.classList&&w.current.classList.remove("hide"),ce<=0&&N(),ce=3}function N(){setTimeout((function(){--ce>0?N():w.current&&!j.current.paused&&w.current.classList.add("hide")}),1e3)}function I(){l||h||(P(),p?j.current.pause():j.current.play(),x(!1),d(!1))}function Z(){g(!j.current.paused)}if(null==e.src)return(0,r.jsx)(r.Fragment,{});var S=decodeURIComponent(e.src).replace(/\/+$/,"").replace(/^([a-zA-Z]+:\/\/)?\/?([^\/]+\/)+/,"").replace(/\.[a-zA-Z0-9]+$/,"");return(0,r.jsxs)(V,{ref:m,onMouseMove:P,children:[(0,r.jsx)(U,{onPlay:Z,onPause:Z,onTimeUpdate:function(){var e=100*j.current.currentTime/j.current.duration;i(e)},onError:function(){d(!1),x(j.current.error.message)},onCanPlay:function(){if(l){k.current.style.height=100*j.current.volume+"%";var e=C.getVideoTime(j.current.src);e>0&&j.current.duration-15>e&&(j.current.currentTime=e),d(!1),C.startAutoSaving(j.current.src,j.current)}},src:e.src,autoPlay:!0,controls:!1,ref:j}),(0,r.jsxs)(M,{ref:w,children:[(0,r.jsxs)(G,{children:[(0,r.jsx)(O,{children:S}),(0,r.jsx)($,{style:{display:e.backUrl?"":"none"},href:e.backUrl,onClick:function(){j.current.src=null,g(!1),i(0),d(!0)},children:(0,r.jsx)(B.G,{icon:E.EyR})})]}),(0,r.jsxs)(X,{children:[l&&(0,r.jsx)(q,{}),h&&(0,r.jsx)(ne,{children:"Erro ao carregar v\xeddeo"}),!l&&!h&&(0,r.jsxs)(H,{children:[(0,r.jsx)("button",{className:"buttonSmall",onClick:function(){j.current.currentTime-=5},children:(0,r.jsx)(B.G,{icon:E.XnX})}),(0,r.jsx)("button",{className:"buttonBig",onClick:I,children:(0,r.jsx)(B.G,{icon:p?E.XQY:E.zc})}),(0,r.jsx)("button",{className:"buttonSmall",onClick:function(){j.current.currentTime+=5},children:(0,r.jsx)(B.G,{icon:E.mHK})})]})]}),(0,r.jsxs)(D,{children:[(0,r.jsx)(J,{onClick:I,children:(0,r.jsx)(B.G,{icon:p?E.XQY:E.zc})}),(0,r.jsx)(Q,{onClick:function(e){if(!l&&!h){var n=y.current.getBoundingClientRect(),t=100*(e.clientX-n.left)/(n.right-n.left);j.current.currentTime=j.current.duration/100*t,i(t)}},onMouseMove:function(e){var n=y.current.getBoundingClientRect(),t=100*(e.clientX-n.left)/(n.right-n.left);s(t)},ref:y,children:(0,r.jsxs)("div",{className:"background",children:[(0,r.jsx)(K,{style:{width:"".concat(t,"%")}}),(0,r.jsx)(W,{className:"follower",style:{marginLeft:"-".concat(t,"%"),width:"".concat(a,"%")},ref:v})]})}),(0,r.jsxs)(ee,{children:[(0,r.jsx)("div",{className:"volume",ref:b,onClick:function(e){var n=b.current.getBoundingClientRect(),t=1*(n.bottom-e.clientY)/(n.bottom-n.top);j.current.volume=t,k.current.style.height=100*t+"%"},children:(0,r.jsx)("div",{className:"volume_percent",ref:k})}),(0,r.jsx)(J,{children:(0,r.jsx)(B.G,{icon:E.ihg})})]}),(0,r.jsx)(J,{onClick:function(){document.fullscreenElement?(document.exitFullscreen(),screen.orientation.unlock()):(m.current.requestFullscreen(),screen.orientation.lock("landscape"))},children:(0,r.jsx)(B.G,{icon:E.TL5})})]})]})]})}var de=t(983),ue=function(){function e(){var n;(0,k.Z)(this,e),(0,C.Z)(this,"API_URL",null!==(n="/api")?n:"/api"),(0,C.Z)(this,"api",void 0),this.api=N().create({baseURL:"".concat(this.API_URL),timeout:5e3})}return(0,j.Z)(e,[{key:"getFiles",value:function(e,n,t){var i=this,o=this.clearPath(e);this.api.get("/files?path=".concat(encodeURIComponent("/".concat(o)))).then((function(e){if(204==e.status)return n([],o);var t=Object.values(e.data.files).map((function(e){if(!e.type){var n=(0,de.lookup)(e.name);n&&(e.type=n)}return e.icon&&(e.icon=i.getFileSrc(e.icon)),e}));t=t.sort((function(e,n){return(""+e.name).localeCompare(n.name,void 0,{numeric:!0})})),n(t,o)})).catch((function(e){if(console.error(e),t){var n=500;try{var o=e.toJSON();o&&o.status&&(n=o.status)}catch(a){}var r=i.getErrorMessage(n);t(n,r)}}))}},{key:"openFile",value:function(e,n){var t=n.replace(/\/[^\/]+\/?$/,"");return{name:e.name,type:e.type,parent:t,src:this.getFileSrc(n)}}},{key:"getFileSrc",value:function(e){return"".concat(this.API_URL,"/files/open?path=/").concat(encodeURIComponent(e))}},{key:"clearPath",value:function(e){return null==e?"":decodeURI(e.replace(/\/\/+/,"/").replace(/^\/+/,"").replace(/\/+$/,"").trim())}},{key:"getErrorMessage",value:function(e){switch(e){case 404:return"Arquivo ou diret\xf3rio n\xe3o encontrado!";case 403:return"Voc\xea n\xe3o tem permiss\xe3o para acessar esse arquivo ou diret\xf3rio!";case 500:return"Erro interno ao processar arquivo!";default:return"Erro desconhecido ao processar requisi\xe7\xe3o!"}}}]),e}(),pe=(0,i.F4)(["from{transform:translateX(100%);}to{transform:translateY(0);}"]),ge=i.ZP.div.withConfig({displayName:"styles__AudioContent",componentId:"sc-1cnkxui-0"})(["position:fixed;bottom:10px;right:10px;width:580px;transition:200ms;animation:"," 200ms linear normal;display:flex;flex-direction:column;z-index:1;@media(max-width:780px){width:auto;left:10px;}"],pe),fe=i.ZP.div.withConfig({displayName:"styles__AudioElement",componentId:"sc-1cnkxui-1"})(["background:linear-gradient(90deg,#006DAC,#00A2FF);box-shadow:0 4px 4px 0px rgba(0,0,0,0.25);display:flex;flex-direction:column;height:90px;border-radius:15px;width:100%;"]),he=i.ZP.div.withConfig({displayName:"styles__ContentHeader",componentId:"sc-1cnkxui-2"})(["display:flex;"]),xe=i.ZP.div.withConfig({displayName:"styles__ControlContent",componentId:"sc-1cnkxui-3"})(["display:flex;margin:0 0 0 15px;"]),me=i.ZP.button.withConfig({displayName:"styles__ControlButton",componentId:"sc-1cnkxui-4"})(["background-color:transparent;cursor:pointer;border:none;color:white;margin:auto 6px;font-size:22pt;transition:200ms;&:hover{color:#d9d9d9;transform:translateY(-1px);}"]),we=(0,i.F4)(["from{transform:rotate(0);}to{transform:rotate(360deg);}"]),ve=i.ZP.div.withConfig({displayName:"styles__LoadingSpin",componentId:"sc-1cnkxui-5"})(['display:flex;&:before{content:"";width:15px;height:15px;margin:auto;border-radius:50%;border:solid 5px transparent;border-top-color:white;animation:'," 500ms linear infinite;}"],we),ye=i.ZP.div.withConfig({displayName:"styles__VolumeControl",componentId:"sc-1cnkxui-6"})(["display:flex;"]),be=i.ZP.div.withConfig({displayName:"styles__VolumeProgress",componentId:"sc-1cnkxui-7"})(['background-color:#D9D9D9;cursor:pointer;height:5px;width:75px;margin:auto 0;border-radius:5px;display:flex;&::after{content:"";display:block;margin:-5px -5px 0 -5px;width:5px;height:5px;background-color:white;border:solid 5px white;border-radius:50%;box-shadow:0 0 5px 0 rgba(0,0,0,0.25);}']),_e=i.ZP.div.withConfig({displayName:"styles__VolumeProgressBar",componentId:"sc-1cnkxui-8"})(["background-color:white;;height:100%;display:flex;border-radius:5px;"]),ke=i.ZP.h3.withConfig({displayName:"styles__AudioTitle",componentId:"sc-1cnkxui-9"})(["white-space:nowrap;overflow-x:hidden;text-overflow:ellipsis;text-align:center;width:100%;margin:auto 15px;"]),je=i.ZP.div.withConfig({displayName:"styles__AudioDurationContent",componentId:"sc-1cnkxui-10"})(["display:flex;flex-direction:column;"]),Ce=i.ZP.p.withConfig({displayName:"styles__AudioDurationCount",componentId:"sc-1cnkxui-11"})(["color:white;font-size:10pt;margin:0 15px;text-align:right;"]),Pe=i.ZP.div.withConfig({displayName:"styles__AudioProgress",componentId:"sc-1cnkxui-12"})(['background-color:#D9D9D9;cursor:pointer;display:flex;height:5px;margin:auto 15px;border-radius:5px;&::after{content:"";display:block;position:relative;margin:-5px -5px 0 -5px;width:5px;height:5px;background-color:white;border:solid 5px white;border-radius:50%;box-shadow:0 0 5px 0 rgba(0,0,0,0.25);}']),Ne=i.ZP.div.withConfig({displayName:"styles__AudioProgressBar",componentId:"sc-1cnkxui-13"})(["background-color:white;;height:100%;display:flex;border-radius:5px;"]),Ie=i.ZP.div.withConfig({displayName:"PlayList__PlayListContent",componentId:"sc-1p83xcd-0"})(["background-color:#0B4F75;box-shadow:0 5px 5px 0 rgba(0,0,0,0.25);display:flex;flex-direction:column;height:200px;margin-top:20px;margin-bottom:-10px;padding-bottom:15px;border-radius:15px 15px 0 0;overflow-y:hidden;transition:height 500ms;"]),Ze=i.ZP.div.withConfig({displayName:"PlayList__PlaylistHeader",componentId:"sc-1p83xcd-1"})(["padding:10px;text-align:center;border-radius:15px 15px 0 0;background-color:rgba(0,0,0,0.2);overflow-y:hidden;"]),Se=i.ZP.div.withConfig({displayName:"PlayList__MusicCol",componentId:"sc-1p83xcd-2"})(["display:flex;flex-direction:column;overflow-y:scroll;height:100%;"]),Le=i.ZP.div.withConfig({displayName:"PlayList__MusicRow",componentId:"sc-1p83xcd-3"})(["display:flex;& p{display:block;background-color:transparent;border:none;color:white;font-weight:600;white-space:nowrap;overflow-x:hidden;text-overflow:ellipsis;font-size:11pt;padding:5px;cursor:pointer;&:hover{text-decoration:underline;}}"]);function Fe(e){var n=(0,_.useState)(null),t=n[0],i=n[1];return(0,_.useEffect)((function(){i(e.playing)}),[e.playing]),(0,r.jsxs)(Ie,{style:e.open?{}:{height:0,padding:0},children:[(0,r.jsx)(Ze,{children:(0,r.jsx)("h3",{children:"Lista de m\xfasicas"})}),(0,r.jsx)(Se,{children:e.playlist.map((function(n,i){return(0,r.jsxs)(Le,{onClick:function(){return function(n){e.onClick&&e.onClick(n)}(i)},children:[(0,r.jsxs)("p",{children:[i+1,". ",n]}),null!=t&&i==t&&(0,r.jsx)(B.G,{icon:E.ihg,style:{margin:"auto 5px auto auto"}})]},i)}))})]})}function ze(e){var n=e.playlist,t=(0,_.useState)(e.src),i=t[0],o=t[1],a=(0,_.useState)(!0),s=a[0],c=a[1],l=(0,_.useState)(!1),d=l[0],u=l[1],p=(0,_.useState)(0),g=p[0],f=p[1],h=(0,_.useState)(0),x=h[0],m=h[1],w=(0,_.useState)("00:00"),v=w[0],y=w[1],b=(0,_.useState)("00:00"),k=b[0],j=b[1],C=(0,_.useState)(!1),P=C[0],N=C[1],I=(0,_.useRef)(),Z=(0,_.useRef)(),S=(0,_.useRef)();function L(e){return decodeURIComponent(e).replace(/\/+$/,"").replace(/^([a-zA-Z]+:\/\/)?\/?([^\/]+\/)+/,"").replace(/\.[a-zA-Z0-9]+$/,"")}(0,_.useEffect)((function(){c(!0),o(e.src)}),[e.src]);var F=L(i);function z(){u(!I.current.paused)}function R(){c(!0);var e=n.indexOf(i);e<0||e+1>=n.length?o(n[0]):o(n[e+1])}function A(){c(!0);var e=n.indexOf(i);o(e<=0?n[n.length-1]:n[e-1])}function T(e){var n=e%60,t=(e-n)/60/60,i="".concat(((e-n)/60%60).toFixed(0).padStart(2,"0"),":").concat(n.toFixed(0).padStart(2,"0"));return t>=1&&(i="".concat(t.toFixed(0).padStart(2,"0"),":").concat(i)),i}return(0,r.jsxs)(ge,{children:[(0,r.jsx)(Fe,{open:P,playlist:n.map((function(e){return L(e)})),playing:i?n.indexOf(i):null,onClick:function(e){var t=n[e];o(t)}}),(0,r.jsxs)(fe,{children:[(0,r.jsx)(he,{children:(0,r.jsx)(me,{style:{height:"16px",display:"flex",marginLeft:"auto",padding:"5px"},onClick:function(){N(!P)},children:(0,r.jsx)(B.G,{icon:E.onQ,style:{fontSize:"16pt",margin:"auto"}})})}),(0,r.jsxs)(xe,{children:[(0,r.jsx)(me,{onClick:A,disabled:n.length<=0,children:(0,r.jsx)(B.G,{icon:E.J0P})}),(0,r.jsx)(me,{onClick:function(){d?I.current.pause():I.current.play()},children:s?(0,r.jsx)(ve,{}):(0,r.jsx)(B.G,{icon:d?E.XQY:E.zc})}),(0,r.jsx)(me,{onClick:R,disabled:n.length<=0,children:(0,r.jsx)(B.G,{icon:E.Jwg})}),(0,r.jsxs)(ye,{children:[(0,r.jsx)(me,{style:{display:"flex"},children:(0,r.jsx)(B.G,{icon:E.ihg,style:{fontSize:"16pt"}})}),(0,r.jsx)(be,{onClick:function(e){var n=S.current.getBoundingClientRect(),t=100*(e.clientX-n.left)/(n.right-n.left);I.current.volume=t/100,localStorage.setItem("audio_volume",I.current.volume.toString()),m(t)},ref:S,children:(0,r.jsx)(_e,{style:{width:"".concat(x,"%")}})})]}),(0,r.jsx)(ke,{children:F})]}),(0,r.jsxs)(je,{children:[(0,r.jsxs)(Ce,{children:[k,"/",v]}),(0,r.jsx)(Pe,{onClick:function(e){var n=Z.current.getBoundingClientRect(),t=100*(e.clientX-n.left)/(n.right-n.left);I.current.currentTime=I.current.duration/100*t,f(t)},ref:Z,children:(0,r.jsx)(Ne,{style:{width:"".concat(g,"%")}})})]}),(0,r.jsx)("audio",{autoPlay:!0,src:i,onPlay:z,onPause:z,onCanPlay:function(){s&&(navigator.mediaSession.metadata=new MediaMetadata({title:F}),navigator.mediaSession.setActionHandler("previoustrack",A),navigator.mediaSession.setActionHandler("nexttrack",R),I.current.volume=localStorage.getItem("audio_volume")?Number(localStorage.getItem("audio_volume")):.5,c(!1),m(100*I.current.volume),y(T(I.current.duration)))},onTimeUpdate:function(){var e=100*I.current.currentTime/I.current.duration;f(e),j(T(I.current.currentTime))},onEnded:R,ref:I})]})]})}var Re=i.ZP.div.withConfig({displayName:"pages__Container",componentId:"sc-keronp-0"})(['display:grid;grid-template-columns:220px auto;grid-template-rows:64px auto;grid-template-areas:"h n" "m a";height:100vh;transition:grid-template-columns .2s;@media(max-width:950px){grid-template-columns:0 auto}']),Ae=i.ZP.header.withConfig({displayName:"pages__Header",componentId:"sc-keronp-1"})(["grid-area:h;display:flex;overflow:hidden;background:rgba(0,0,0,0.5);& .title{margin:auto;}"]),Te=i.ZP.button.withConfig({displayName:"pages__CollapseButtom",componentId:"sc-keronp-2"})(["display:none;color:white;background-color:transparent;border:none;font-size:15pt;margin:auto 20px;cursor:pointer;&:hover{color:#dddddd;}@media(max-width:950px){display:block;}"]),Be=i.ZP.nav.withConfig({displayName:"pages__Nav",componentId:"sc-keronp-3"})(["grid-area:n;display:flex;background:rgba(0,0,0,0.5);overflow-x:scroll;white-space:nowrap;"]),Ee=i.ZP.main.withConfig({displayName:"pages__Main",componentId:"sc-keronp-4"})(["grid-area:m;overflow-y:scroll;background:rgba(0,0,0,0.5);"]),Ve=i.ZP.aside.withConfig({displayName:"pages__Aside",componentId:"sc-keronp-5"})(["grid-area:a;overflow-y:scroll;background:rgba(9,9,9,0.3);"]),Ue=i.ZP.div.withConfig({displayName:"pages__PathLink",componentId:"sc-keronp-6"})(["font-size:11pt;font-weight:bold;margin:auto 25px;color:white;& a{color:white;margin:0 2px;padding:2px;border-radius:5px;&:hover{background-color:rgba(255,255,255,0.3);}}"]);function Me(){var e=new ue,n=(0,_.useState)([]),t=n[0],i=n[1],o=(0,_.useState)(null),a=o[0],s=o[1],c=(0,_.useState)(!1),l=c[0],d=c[1],u=(0,_.useState)(),p=u[0],g=u[1],f=(0,_.useState)(),h=f[0],x=f[1],w=(0,_.useState)(),v=w[0],y=w[1],k=(0,_.useState)([]),j=k[0],C=k[1],P=(0,_.useState)(!1),N=P[0],I=P[1],Z=(0,_.useState)(null),S=Z[0],L=Z[1];function F(){d(!1),e.getFiles(null,(function(e){i(e.filter((function(e){return e.is_dir})).map((function(e){return e.href="#/".concat(e.name),e}))),z()}),(function(e,n){if(401==e)return d(!0);g(n)}))}function z(){var n=arguments.length>0&&void 0!==arguments[0]?arguments[0]:location.hash.substring(1),t=arguments.length>1&&void 0!==arguments[1]?arguments[1]:null;s(null),g(null),e.getFiles(n,(function(n,i){if(1==n.length&&n[0].open){var o=e.openFile(n[0],i);z(o.parent,(function(e){return R(o,e)}))}else{L(i);var r=n.map((function(e){return e.href=i?"#/".concat(i,"/").concat(e.name):"#/".concat(e.name),e}));s(r),t&&t(r)}}),(function(e,n){if(401==e)return d(!0);g(n)}))}function R(n,t){if(y(null),x(null),n.type){if(n.type.match(/video\/(mp4|webm|ogg|mkv)/))return void x(n);if(n.type.match(/audio\/(mpeg|mp3|ogg|(x-(pn-)?)?wav)/))return y(n),void C(t?t.filter((function(e){var n;return null===(n=e.type)||void 0===n?void 0:n.match(/audio\/(mpeg|mp3|ogg|(x-(pn-)?)?wav)/)})).map((function(t){return e.getFileSrc("".concat(n.parent,"/").concat(t.name))})):[])}location.href=n.src}return(0,_.useEffect)((function(){window.onhashchange=function(){x(null),z()},F()}),[]),(0,r.jsxs)(Re,{style:{gridTemplateColumns:N?"220px auto":null},children:[(0,r.jsx)(Ae,{children:(0,r.jsx)("h2",{className:"title",children:(0,r.jsx)("a",{href:"#",children:"RaspAdmin"})})}),(0,r.jsxs)(Be,{children:[(0,r.jsx)(Te,{onClick:function(){I(!N)},children:(0,r.jsx)(B.G,{icon:E.xiG})}),(0,r.jsxs)(Ue,{children:["/",(0,r.jsx)("a",{href:"#/",children:"home"}),S&&S.split("/").map((function(e,n){var t="";return S.split("/").forEach((function(e,i){i<=n&&(t+="/".concat(e))})),(0,r.jsxs)(r.Fragment,{children:["/",(0,r.jsx)("a",{href:"#".concat(t),children:e},n)]})}))]})]}),(0,r.jsx)(Ee,{children:(0,r.jsx)(b,{files:t.filter((function(e){return e.is_dir}))})}),(0,r.jsx)(Ve,{children:(0,r.jsx)(m,{files:a,text:p})}),h&&(0,r.jsx)(le,{src:h.src,backUrl:"#".concat(h.parent)}),v&&(0,r.jsx)(ze,{src:v.src,playlist:j}),l&&(0,r.jsx)(T,{onSuccess:F})]})}},8312:function(e,n,t){(window.__NEXT_P=window.__NEXT_P||[]).push(["/",function(){return t(8586)}])}},function(e){e.O(0,[976,75,774,888,179],(function(){return n=8312,e(e.s=n);var n}));var n=e.O();_N_E=n}]);