(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["pages-detail-detail"],{3440:function(t,e,a){"use strict";a.r(e);var n=a("43ab"),i=a.n(n);for(var r in n)"default"!==r&&function(t){a.d(e,t,(function(){return n[t]}))}(r);e["default"]=i.a},"43ab":function(t,e,a){"use strict";(function(t){var n=a("4ea4");a("99af"),a("4160"),a("a9e3"),a("e25e"),a("ac1f"),a("1276"),a("159b"),Object.defineProperty(e,"__esModule",{value:!0}),e.default=void 0;n(a("f5a9"));var i="<p>获取信息失败1</p>";var r={data:function(){return{banner:{},content:""}},mounted:function(){function t(){var t=document.getElementById("mobsf"),e=document.body.clientWidth,a=document.body.clientHeight;t.style.width=Number(e)-10+"px",t.style.height=Number(a)-8+"px"}t(),window.onresize=function(){t()}},onShareAppMessage:function(){return{title:this.banner.title,path:"/pages/detail/detail?query="+JSON.stringify(this.banner)}},onLoad:function(t){try{this.banner=JSON.parse(decodeURIComponent(t.query))}catch(e){this.banner=JSON.parse(t.query)}uni.setNavigationBarTitle({title:this.banner.title}),this.getDetail()},methods:{getDetail:function(){var e=this;uni.request({method:"GET",url:this.banner.linkurl,success:function(a){t("log","url= "+e.banner.linkurl," at pages/detail/detail.nvue:101");var n=i;200==a.statusCode&&(n=a.data),e.content=n}})}}};e.default=r;(function(){var t=document.createElement("script");t.src="https://hm.baidu.com/hm.js?6015536b970ef148edc32e4ab81fdc34";var e=document.getElementsByTagName("script")[0];e.parentNode.insertBefore(t,e)})()}).call(this,a("0de9")["log"])},"4fcb4":function(t,e,a){var n=a("24fb");e=n(!1),e.push([t.i,"\nuni-page-body[data-v-a176a306]{min-height:100%}\n.banner[data-v-a176a306]{height:%?150?%;position:relative;background-color:#ccc;-webkit-box-orient:horizontal;-webkit-box-direction:normal;-webkit-flex-direction:row;flex-direction:row;overflow:hidden}.banner-img[data-v-a176a306]{-webkit-box-flex:1;-webkit-flex:1;flex:1}.title-area[data-v-a176a306]{position:absolute;left:%?30?%;right:%?30?%;bottom:%?30?%;z-index:11}.title-text[data-v-a176a306]{font-size:%?32?%;font-weight:400;line-height:%?42?%;lines:2;color:#fff;overflow:hidden}.article-meta[data-v-a176a306]{padding:%?20?% %?30?%;-webkit-box-orient:horizontal;-webkit-box-direction:normal;-webkit-flex-direction:row;flex-direction:row;-webkit-box-align:center;-webkit-align-items:center;align-items:center;-webkit-box-pack:start;-webkit-justify-content:flex-start;justify-content:flex-start}.article-meta-text[data-v-a176a306]{color:grey}.article-text[data-v-a176a306]{font-size:%?26?%;line-height:%?50?%;margin:0 %?20?%}.article-author[data-v-a176a306]{font-size:%?30?%}.article-time[data-v-a176a306]{font-size:%?30?%}.article-content[data-v-a176a306]{font-size:%?30?%;padding:0 %?30?%;margin-bottom:%?30?%;overflow:hidden}",""]),t.exports=e},"5ce6":function(t,e,a){"use strict";a.r(e);var n=a("9418"),i=a("3440");for(var r in i)"default"!==r&&function(t){a.d(e,t,(function(){return i[t]}))}(r);a("f671");var s,o=a("f0c5"),c=Object(o["a"])(i["default"],n["b"],n["c"],!1,null,"a176a306",null,!1,n["a"],s);e["default"]=c.exports},9418:function(t,e,a){"use strict";var n;a.d(e,"b",(function(){return i})),a.d(e,"c",(function(){return r})),a.d(e,"a",(function(){return n}));var i=function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("v-uni-view",[a("v-uni-view",{staticClass:"banner",attrs:{"auto-focus":!0}},[a("v-uni-image",{staticClass:"banner-img",attrs:{src:t.banner.image_url}}),a("v-uni-view",{staticClass:"title-area"},[a("v-uni-text",{staticClass:"title-text"},[t._v(t._s(t.banner.title))])],1)],1),a("v-uni-view",{staticClass:"article-meta"},[a("v-uni-text",{staticClass:"article-meta-text article-author"},[t._v(t._s(t.banner.source))]),a("v-uni-text",{staticClass:"article-meta-text article-text"},[t._v("发表于")]),a("v-uni-text",{staticClass:"article-meta-text article-time"},[t._v(t._s(t.banner.datetime))]),a("a",{attrs:{target:"_blank",href:t.banner.linkurl}},[a("v-uni-text",{staticClass:"article-meta-text article-text"},[t._v("查看详情")])],1)],1),a("v-uni-view",{staticClass:"article-content"},[a("v-uni-rich-text",{staticStyle:{"font-size":"14px"}},[t._v(t._s(t.content))])],1),a("v-uni-view",{staticClass:"comment-wrap"}),a("v-uni-view",[a("iframe",{staticStyle:{position:"absolute",top:"1px",left:"0px"},attrs:{src:t.banner.linkurl,id:"mobsf",scrolling:"yes",frameborder:"0"}})])],1)},r=[]},c525:function(t,e,a){var n=a("4fcb4");"string"===typeof n&&(n=[[t.i,n,""]]),n.locals&&(t.exports=n.locals);var i=a("4f06").default;i("cb026fa6",n,!0,{sourceMap:!1,shadowMode:!1})},f5a9:function(t,e,a){"use strict";(function(t){a("c975"),a("13d5"),a("4d63"),a("ac1f"),a("25f0"),a("466d"),a("5319"),a("1276"),Object.defineProperty(e,"__esModule",{value:!0}),e.default=void 0;var n=/^<([-A-Za-z0-9_]+)((?:\s+[a-zA-Z_:][-a-zA-Z0-9_:.]*(?:\s*=\s*(?:(?:"[^"]*")|(?:'[^']*')|[^>\s]+))?)*)\s*(\/?)>/,i=/^<\/([-A-Za-z0-9_]+)[^>]*>/,r=/([a-zA-Z_:][-a-zA-Z0-9_:.]*)(?:\s*=\s*(?:(?:"((?:\\.|[^"])*)")|(?:'((?:\\.|[^'])*)')|([^>\s]+)))?/g,s=h("area,base,basefont,br,col,frame,hr,img,input,link,meta,param,embed,command,keygen,source,track,wbr"),o=h("a,address,article,applet,aside,audio,blockquote,button,canvas,center,dd,del,dir,div,dl,dt,fieldset,figcaption,figure,footer,form,frameset,h1,h2,h3,h4,h5,h6,header,hgroup,hr,iframe,isindex,li,map,menu,noframes,noscript,object,ol,output,p,pre,section,script,table,tbody,td,tfoot,th,thead,tr,ul,video"),c=h("abbr,acronym,applet,b,basefont,bdo,big,br,button,cite,code,del,dfn,em,font,i,iframe,img,input,ins,kbd,label,map,object,q,s,samp,script,select,small,span,strike,strong,sub,sup,textarea,tt,u,var"),l=h("colgroup,dd,dt,li,options,p,td,tfoot,th,thead,tr"),u=h("checked,compact,declare,defer,disabled,ismap,multiple,nohref,noresize,noshade,nowrap,readonly,selected"),d=h("script,style");function f(t,e){var a,f,h,b=[],p=t;b.last=function(){return this[this.length-1]};while(t){if(f=!0,b.last()&&d[b.last()])t=t.replace(new RegExp("([\\s\\S]*?)</"+b.last()+"[^>]*>"),(function(t,a){return a=a.replace(/<!--([\s\S]*?)-->|<!\[CDATA\[([\s\S]*?)]]>/g,"$1$2"),e.chars&&e.chars(a),""})),g("",b.last());else if(0==t.indexOf("\x3c!--")?(a=t.indexOf("--\x3e"),a>=0&&(e.comment&&e.comment(t.substring(4,a)),t=t.substring(a+3),f=!1)):0==t.indexOf("</")?(h=t.match(i),h&&(t=t.substring(h[0].length),h[0].replace(i,g),f=!1)):0==t.indexOf("<")&&(h=t.match(n),h&&(t=t.substring(h[0].length),h[0].replace(n,m),f=!1)),f){a=t.indexOf("<");var v=a<0?t:t.substring(0,a);t=a<0?"":t.substring(a),e.chars&&e.chars(v)}if(t==p)throw"Parse Error: "+t;p=t}function m(t,a,n,i){if(a=a.toLowerCase(),o[a])while(b.last()&&c[b.last()])g("",b.last());if(l[a]&&b.last()==a&&g("",a),i=s[a]||!!i,i||b.push(a),e.start){var d=[];n.replace(r,(function(t,e){var a=arguments[2]?arguments[2]:arguments[3]?arguments[3]:arguments[4]?arguments[4]:u[e]?e:"";d.push({name:e,value:a,escaped:a.replace(/(^|[^\\])"/g,'$1\\"')})})),e.start&&e.start(a,d,i)}}function g(t,a){if(a){for(n=b.length-1;n>=0;n--)if(b[n]==a)break}else var n=0;if(n>=0){for(var i=b.length-1;i>=n;i--)e.end&&e.end(b[i]);b.length=n}}g()}function h(t){for(var e={},a=t.split(","),n=0;n<a.length;n++)e[a[n]]=!0;return e}function b(t){return t.replace(/<\?xml.*\?>\n/,"").replace(/<!doctype.*>\n/,"").replace(/<!DOCTYPE.*>\n/,"")}function p(t){return t.reduce((function(t,e){var a=e.value,n=e.name;return t[n]?t[n]=t[n]+" "+a:t[n]=a,t}),{})}function v(e){e=b(e);var a=[],n={node:"root",children:[]};return f(e,{start:function(t,e,i){var r={name:t};if(0!==e.length&&(r.attrs=p(e)),i){var s=a[0]||n;s.children||(s.children=[]),s.children.push(r)}else a.unshift(r)},end:function(e){var i=a.shift();if(i.name!==e&&t("error","invalid state: mismatch end tag"," at common/html-parser.js:303"),0===a.length)n.children.push(i);else{var r=a[0];r.children||(r.children=[]),r.children.push(i)}},chars:function(t){var e={type:"text",text:t};if(0===a.length)n.children.push(e);else{var i=a[0];i.children||(i.children=[]),i.children.push(e)}},comment:function(t){var e={node:"comment",text:t},n=a[0];n.children||(n.children=[]),n.children.push(e)}}),n.children}var m=v;e.default=m}).call(this,a("0de9")["log"])},f671:function(t,e,a){"use strict";var n=a("c525"),i=a.n(n);i.a}}]);