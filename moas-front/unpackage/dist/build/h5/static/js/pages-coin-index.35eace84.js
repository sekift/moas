(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["pages-coin-index"],{1588:function(t,e,i){"use strict";var a=i("e441"),n=i.n(a);n.a},"169c":function(t,e,i){"use strict";var a;i.d(e,"b",(function(){return n})),i.d(e,"c",(function(){return o})),i.d(e,"a",(function(){return a}));var n=function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("v-uni-view",{staticClass:"tabs"},[i("v-uni-scroll-view",{ref:"tabbar1",staticClass:"tab-bar",attrs:{id:"tab-bar",scroll:!1,"scroll-x":!0,"show-scrollbar":!1,"scroll-into-view":t.scrollInto}},[i("v-uni-view",{staticStyle:{"flex-direction":"column"}},[i("v-uni-view",{staticStyle:{"flex-direction":"row"}},[i("v-uni-view",{staticClass:"uni-tab-item"},[i("v-uni-text",{staticClass:"uni-tab-item-title"})],1)],1),i("v-uni-view",{staticClass:"scroll-view-indicator"},[i("v-uni-view",{ref:"underline",staticClass:"scroll-view-underline",class:t.isTap?"scroll-view-animation":"",style:{left:t.indicatorLineLeft+"px",width:t.indicatorLineWidth+"px"}})],1)],1)],1),i("v-uni-view",{staticClass:"tab-bar-line"})],1)},o=[]},"18bc":function(t,e,i){"use strict";var a=i("ee30"),n=i.n(a);n.a},"3eb5":function(t,e,i){"use strict";var a;i.d(e,"b",(function(){return n})),i.d(e,"c",(function(){return o})),i.d(e,"a",(function(){return a}));var n=function(){var t=this,e=t.$createElement,i=t._self._c||e;return t.newsItem.title?i("v-uni-view",{staticClass:"media-item view",on:{click:function(e){arguments[0]=e=t.$handleEvent(e),t.click.apply(void 0,arguments)}}},[i("v-uni-view",{staticClass:"view",style:{flexDirection:1===t.newsItem.article_type||2===t.newsItem.article_type?2===t.newsItem.article_type?"row":"row-reverse":"column"}},[i("v-uni-text",{staticClass:"media-title",class:{"media-title2":1===t.newsItem.article_type||2===t.newsItem.article_type}},[t._v(t._s(t.newsItem.title))]),t.newsItem.image_list||t.newsItem.image_url?i("v-uni-view",{staticClass:"image-section flex-row",class:{"image-section-right":2===t.newsItem.article_type,"image-section-left":1===t.newsItem.article_type}},[t.newsItem.image_url?i("v-uni-image",{staticClass:"image-list1",class:{"image-list2":1===t.newsItem.article_type||2===t.newsItem.article_type},attrs:{"fade-show":!1,src:t.newsItem.image_url}}):t._e(),t._l(t.newsItem.image_list,(function(e,a){return t.newsItem.image_list?i("v-uni-image",{key:a,staticClass:"image-list3",attrs:{"fade-show":!1,src:e.url}}):t._e()}))],2):t._e()],1),i("v-uni-view",{staticClass:"media-foot flex-row"},[i("v-uni-view",{staticClass:"media-info flex-row"},[t.newsItem.coinName?i("v-uni-view",[i("v-uni-text",{staticClass:"info-text",staticStyle:{color:"red"}},[t._v(t._s(t.newsItem.coinName))])],1):t._e(),i("v-uni-text",{staticClass:"info-text"},[t._v("量 "+t._s(t.newsItem.vol))]),i("v-uni-text",{staticClass:"info-text"},[t._v("高 "+t._s(t.newsItem.high))]),i("v-uni-text",{staticClass:"info-text"},[t._v(t._s(t.newsItem.datetime))])],1),i("v-uni-view",{staticClass:"close-view",on:{click:function(e){e.stopPropagation(),arguments[0]=e=t.$handleEvent(e),t.close.apply(void 0,arguments)}}},[i("v-uni-view",{staticClass:"close-l close-h"}),i("v-uni-view",{staticClass:"close-l close-v"})],1)],1),i("v-uni-view",{staticClass:"media-item-line",staticStyle:{position:"absolute"}})],1):t._e()},o=[]},"402e":function(t,e,i){var a=i("24fb");e=a(!1),e.push([t.i,"\nuni-page-body[data-v-60a06a76]{width:100%;min-height:100%;display:flex}\n.tabs[data-v-60a06a76]{flex:1;flex-direction:column;overflow:hidden;background-color:#fff;\n}.tab-bar[data-v-60a06a76]{width:%?750?%;height:%?84?%;flex-direction:row;\nwhite-space:nowrap\n}\n.tab-bar[data-v-60a06a76] ::-webkit-scrollbar{display:none;width:0!important;height:0!important;-webkit-appearance:none;background:transparent}\n.scroll-view-indicator[data-v-60a06a76]{position:relative;height:2px;background-color:initial}.scroll-view-underline[data-v-60a06a76]{position:absolute;top:0;bottom:0;width:0;background-color:#007aff}.scroll-view-animation[data-v-60a06a76]{transition-duration:.2s;transition-property:left}.tab-bar-line[data-v-60a06a76]{height:%?1?%;background-color:#ccc}.tab-box[data-v-60a06a76]{flex:1}.uni-tab-item[data-v-60a06a76]{\ndisplay:inline-block;\nflex-wrap:nowrap;padding-left:20px;padding-right:20px}.uni-tab-item-title[data-v-60a06a76]{color:#555;font-size:%?30?%;height:%?80?%;line-height:%?80?%;flex-wrap:nowrap;\nwhite-space:nowrap\n}.uni-tab-item-title-active[data-v-60a06a76]{color:#007aff}.swiper-item[data-v-60a06a76]{flex:1;flex-direction:column}.page-item[data-v-60a06a76]{flex:1;flex-direction:row;position:absolute;left:0;top:0;right:0;bottom:0}",""]),t.exports=e},6491:function(t,e,i){"use strict";(function(t){var a=i("4ea4");i("99af"),i("d81d"),i("a434"),i("a9e3"),i("d3b7"),i("ac1f"),i("25f0"),i("5319"),Object.defineProperty(e,"__esModule",{value:!0}),e.default=void 0;var n=a(i("ade3")),o=i("7c8c"),r=a(i("79a7")),s=a(i("c2bc")),l=a(i("84a4")),c=a(i("8689")),d=a(i("b14b")),u=a(i("b76b")),f={components:{uniList:r.default,uniCell:s.default,uniRefresh:l.default,uniLoadMore:c.default,noData:d.default,newsItem:u.default},props:{nid:{type:[Number,String],default:""}},data:function(){var t;return t={dataList:[],navigateFlag:!1,pulling:!1,refreshing:!1,refreshFlag:!1,refreshText:"",isLoading:!1,loadingText:"加载中...",isNoData:!1},(0,n.default)(t,"pulling",!1),(0,n.default)(t,"angle",0),(0,n.default)(t,"loadingMoreText",{contentdown:"",contentrefresh:"",contentnomore:""}),(0,n.default)(t,"refreshIcon","data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAADAAAAAwCAMAAABg3Am1AAAAGXRFWHRTb2Z0d2FyZQBBZG9iZSBJbWFnZVJlYWR5ccllPAAAAB5QTFRFcHBw3Nzct7e39vb2ycnJioqK7e3tpqam29vb////D8oK7wAAAAp0Uk5T////////////ALLMLM8AAABxSURBVHja7JVBDoAgDASrjqj//7CJBi90iyYeOHTPMwmFZrHjYyyFYYUy1bwUZqtJIYVxhf1a6u0R7iUvWsCcrEtwJHp8MwMdvh2amHduiZD3rpWId9+BgPd7Cc2LIkPyqvlQvKxKBJ//Qwq/CacAAwDUv0a0YuKhzgAAAABJRU5ErkJggg=="),t},onLoad:function(e){this.que=e.query,t("log",this.que," at pages/coin/news-page.nvue:88")},created:function(){this.pullTimer=null,this.requestParams={sourceid:this.nid,page:1,raws:30}},methods:{loadData:function(e){var i=this;if(!this.isLoading){this.isLoading=!0,this.isNoData=!1,this.requestParams.time=(new Date).getTime()+"";var a=new Date;uni.request({method:"POST",url:"http://8.129.57.86:8086/back-api/api/topcoin/search",success:function(n){t("log","requestParams page="+i.requestParams.page," at pages/coin/news-page.nvue:115");var r=new Date;t("log","request time "+new Date(r-a).getTime()," at pages/coin/news-page.nvue:117");var s=n.data.obj.pages;if(i.requestParams.page>s)i.loadingText="已加载完毕。";else{var l=n.data.obj.list;i.isNoData=l.length<=0;var c=l.map((function(t){return{id:i.newGuid()+t.topid,coinid:t.coinid,coinname:t.coinName,datetime:(0,o.friendlyDate)(new Date(t.createTime.replace(/\-/g,"/")).getTime()),vol:t.vol,high:t.high,low:t.low,lastday:t.lastDay,last:t.last,money:t.money,buy:t.buy,sell:t.sell,coinrange:t.coinRange,diff10:t.diff10,diff30:t.diff30,diff60:t.diff60,diff1260:t.diff1260,diff2460:t.diff2460}}));e?(i.dataList=c,i.requestParams.page=1):(i.dataList=i.dataList.concat(c),i.requestParams.page=i.requestParams.page+1)}},fail:function(e){t("log",e," at pages/coin/news-page.nvue:161"),0==i.dataList.length&&(i.isNoData=!0)},complete:function(t){i.isLoading=!1,e&&(i.refreshing=!1,i.refreshFlag=!1,i.refreshText="已刷新",i.pullTimer&&clearTimeout(i.pullTimer),i.pullTimer=setTimeout((function(){i.pulling=!1}),1e3))}})}},loadMore:function(t){this.loadData()},clear:function(){this.dataList.length=0,this.requestParams.page=1},goDetail:function(t){var e=this;this.navigateFlag||(this.navigateFlag=!0,uni.navigateTo({url:"/pages/detail/detail?query="+encodeURIComponent(JSON.stringify(t))}),setTimeout((function(){e.navigateFlag=!1}),200))},closeItem:function(t){var e=this;uni.showModal({content:"不感兴趣？",success:function(i){i.confirm&&e.dataList.splice(t,1)}})},refreshData:function(){this.isLoading||(this.pulling=!0,this.refreshing=!0,this.refreshText="正在刷新...",this.loadData(!0))},onrefresh:function(t){this.refreshData()},onpullingdown:function(t){this.refreshing||(this.pulling=!1,Math.abs(t.pullingDistance)>Math.abs(t.viewHeight)?(this.refreshFlag=!0,this.refreshText="释放立即刷新"):(this.refreshFlag=!1,this.refreshText="下拉可以刷新"))},newGuid:function(){var t=function(){return(65536*(1+Math.random())|0).toString(16).substring(1)};return(t()+t()+"-"+t()+"-4"+t().substr(0,3)+"-"+t()+"-"+t()+t()+t()).toUpperCase()}}};e.default=f}).call(this,i("0de9")["log"])},"83e8":function(t,e,i){"use strict";var a;i.d(e,"b",(function(){return n})),i.d(e,"c",(function(){return o})),i.d(e,"a",(function(){return a}));var n=function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("v-uni-view",{staticClass:"page-news"},[i("uni-list",{staticClass:"listview",attrs:{enableBackToTop:!0,"scroll-y":!0},on:{scrolltolower:function(e){arguments[0]=e=t.$handleEvent(e),t.loadMore()}}},[i("uni-refresh",{staticClass:"refresh",attrs:{display:t.refreshing?"show":"hide"},on:{refresh:function(e){arguments[0]=e=t.$handleEvent(e),t.onrefresh.apply(void 0,arguments)},pullingdown:function(e){arguments[0]=e=t.$handleEvent(e),t.onpullingdown.apply(void 0,arguments)}}},[i("div",{staticClass:"refresh-view"},[i("v-uni-image",{staticClass:"refresh-icon",class:{"refresh-icon-active":t.refreshFlag},style:{width:t.refreshing||t.pulling?0:"32px"},attrs:{src:t.refreshIcon}}),t.refreshing?i("uni-load-more",{staticClass:"loading-icon",attrs:{status:"loading",contentText:t.loadingMoreText}}):t._e(),i("v-uni-text",{staticClass:"loading-text"},[t._v(t._s(t.refreshText))])],1)]),t._l(t.dataList,(function(e,a){return i("uni-cell",{key:e.id},[i("news-item",{attrs:{newsItem:e},on:{close:function(e){arguments[0]=e=t.$handleEvent(e),t.closeItem(a)},click:function(i){arguments[0]=i=t.$handleEvent(i),t.goDetail(e)}}})],1)})),t.isLoading||t.dataList.length>4?i("uni-cell",[i("v-uni-view",{staticClass:"loading-more"},[i("v-uni-text",{staticClass:"loading-more-text"},[t._v(t._s(t.loadingText))])],1)],1):t._e()],2),t.isNoData?i("no-data",{staticClass:"no-data",on:{retry:function(e){arguments[0]=e=t.$handleEvent(e),t.loadMore.apply(void 0,arguments)}}}):t._e()],1)},o=[]},"86c0":function(t,e,i){"use strict";i.r(e);var a=i("d12d"),n=i.n(a);for(var o in a)"default"!==o&&function(t){i.d(e,t,(function(){return a[t]}))}(o);e["default"]=n.a},a8e2:function(t,e,i){var a=i("24fb");e=a(!1),e.push([t.i,".no-data[data-v-639b24b0]{flex:1;position:absolute;left:0;top:0;right:0;bottom:0;z-index:10}.page-news[data-v-639b24b0]{flex:1;flex-direction:column;position:absolute;left:0;top:0;right:0;bottom:0}.listview[data-v-639b24b0]{position:absolute;left:0;top:0;right:0;bottom:0;\ndisplay:flex;flex-direction:column;\n\nflex-direction:column\n}.refresh[data-v-639b24b0]{justify-content:center}.refresh-view[data-v-639b24b0]{\ndisplay:flex;\nwidth:%?750?%;height:64px;flex-direction:row;flex-wrap:nowrap;align-items:center;justify-content:center}.refresh-icon[data-v-639b24b0]{width:32px;height:32px;transition-duration:.5s;transition-property:-webkit-transform;transition-property:transform;transition-property:transform,-webkit-transform;-webkit-transform:rotate(0deg);transform:rotate(0deg);-webkit-transform-origin:15px 15px;transform-origin:15px 15px}.refresh-icon-active[data-v-639b24b0]{-webkit-transform:rotate(180deg);transform:rotate(180deg)}.loading-icon[data-v-639b24b0]{width:28px;height:28px;margin-right:5px;color:grey}.loading-text[data-v-639b24b0]{margin-left:2px;font-size:16px;color:#999}.loading-more[data-v-639b24b0]{align-items:center;justify-content:center;padding-top:14px;padding-bottom:14px;text-align:center}.loading-more-text[data-v-639b24b0]{font-size:%?28?%;color:#999}",""]),t.exports=e},b140:function(t,e,i){var a=i("24fb");e=a(!1),e.push([t.i,".view[data-v-6bb466c0]{flex-direction:column}.flex-row[data-v-6bb466c0]{flex-direction:row}.flex-col[data-v-6bb466c0]{flex-direction:column}.list-cell[data-v-6bb466c0]{padding:0 %?30?%}.uni-list-cell-hover[data-v-6bb466c0]{background-color:#eee}.media-item[data-v-6bb466c0]{position:relative;flex:1;flex-direction:column;padding:%?20?% %?30?% %?21?% %?30?%}.media-item-line[data-v-6bb466c0]{position:absolute;left:%?30?%;right:%?30?%;bottom:0;height:%?1?%;background-color:#ebebeb}.media-image-right[data-v-6bb466c0]{flex-direction:row}.media-image-left[data-v-6bb466c0]{flex-direction:row-reverse}.media-title[data-v-6bb466c0]{flex:1}.media-title[data-v-6bb466c0]{lines:3;text-overflow:ellipsis;font-size:%?30?%;color:#555}.media-title2[data-v-6bb466c0]{flex:1;margin-top:%?6?%;line-height:%?40?%}.image-section[data-v-6bb466c0]{margin-top:%?20?%;flex-direction:row;justify-content:space-between}.image-section-right[data-v-6bb466c0]{margin-top:%?0?%;margin-left:%?10?%;width:%?225?%;height:%?146?%}.image-section-left[data-v-6bb466c0]{margin-top:%?0?%;margin-right:%?10?%;width:%?225?%;height:%?146?%}.image-list1[data-v-6bb466c0]{width:%?690?%;height:%?481?%}.image-list2[data-v-6bb466c0]{width:%?225?%;height:%?146?%}.image-list3[data-v-6bb466c0]{width:%?225?%;height:%?146?%}.media-info[data-v-6bb466c0]{flex-direction:row;align-items:center}.info-text[data-v-6bb466c0]{margin-right:%?20?%;color:#999;font-size:%?24?%}.media-foot[data-v-6bb466c0]{margin-top:%?25?%;flex-direction:row;align-items:center;justify-content:space-between}.close-view[data-v-6bb466c0]{position:relative;align-items:center;flex-direction:row;width:%?40?%;height:%?30?%;line-height:%?30?%;border-width:%?1?%;border-style:solid;border-color:#aaa;border-radius:4px;justify-content:center;text-align:center}.close-l[data-v-6bb466c0]{position:absolute;width:%?18?%;height:%?1?%;background-color:#aaa}.close-h[data-v-6bb466c0]{-webkit-transform:rotate(45deg);transform:rotate(45deg)}.close-v[data-v-6bb466c0]{-webkit-transform:rotate(-45deg);transform:rotate(-45deg)}",""]),t.exports=e},b76b:function(t,e,i){"use strict";i.r(e);var a=i("3eb5"),n=i("e908");for(var o in n)"default"!==o&&function(t){i.d(e,t,(function(){return n[t]}))}(o);i("1588");var r,s=i("f0c5"),l=Object(s["a"])(n["default"],a["b"],a["c"],!1,null,"6bb466c0",null,!1,a["a"],r);e["default"]=l.exports},b9b5:function(t,e,i){"use strict";i.r(e);var a=i("83e8"),n=i("e405");for(var o in n)"default"!==o&&function(t){i.d(e,t,(function(){return n[t]}))}(o);i("c79f");var r,s=i("f0c5"),l=Object(s["a"])(n["default"],a["b"],a["c"],!1,null,"639b24b0",null,!1,a["a"],r);e["default"]=l.exports},bdee:function(t,e,i){"use strict";i.r(e);var a=i("169c"),n=i("86c0");for(var o in n)"default"!==o&&function(t){i.d(e,t,(function(){return n[t]}))}(o);i("18bc");var r,s=i("f0c5"),l=Object(s["a"])(n["default"],a["b"],a["c"],!1,null,"60a06a76",null,!1,a["a"],r);e["default"]=l.exports},c79f:function(t,e,i){"use strict";var a=i("cde6"),n=i.n(a);n.a},cde6:function(t,e,i){var a=i("a8e2");"string"===typeof a&&(a=[[t.i,a,""]]),a.locals&&(t.exports=a.locals);var n=i("4f06").default;n("3e1aaed0",a,!0,{sourceMap:!1,shadowMode:!1})},d12d:function(t,e,i){"use strict";var a=i("4ea4");Object.defineProperty(e,"__esModule",{value:!0}),e.default=void 0;var n=a(i("b9b5")),o={components:{newsPage:n.default},data:function(){return{tabIndex:0,cacheTab:[],scrollInto:"",navigateFlag:!1,indicatorLineLeft:0,indicatorLineWidth:0,isTap:!1}},onReady:function(){this._lastTabIndex=0,this.swiperWidth=0,this.tabbarWidth=0,this._touchTabIndex=0,this.pageList=this.$refs.page},methods:{}};e.default=o;(function(){var t=document.createElement("script");t.src="https://hm.baidu.com/hm.js?6015536b970ef148edc32e4ab81fdc34";var e=document.getElementsByTagName("script")[0];e.parentNode.insertBefore(t,e)})()},e405:function(t,e,i){"use strict";i.r(e);var a=i("6491"),n=i.n(a);for(var o in a)"default"!==o&&function(t){i.d(e,t,(function(){return a[t]}))}(o);e["default"]=n.a},e441:function(t,e,i){var a=i("b140");"string"===typeof a&&(a=[[t.i,a,""]]),a.locals&&(t.exports=a.locals);var n=i("4f06").default;n("8cff09a6",a,!0,{sourceMap:!1,shadowMode:!1})},e908:function(t,e,i){"use strict";i.r(e);var a=i("ecbb"),n=i.n(a);for(var o in a)"default"!==o&&function(t){i.d(e,t,(function(){return a[t]}))}(o);e["default"]=n.a},ecbb:function(t,e,i){"use strict";Object.defineProperty(e,"__esModule",{value:!0}),e.default=void 0;var a={props:{newsItem:{type:Object,default:function(t){return{}}}},methods:{click:function(){this.$emit("click")},close:function(t){t.stopPropagation(),this.$emit("close")}}};e.default=a},ee30:function(t,e,i){var a=i("402e");"string"===typeof a&&(a=[[t.i,a,""]]),a.locals&&(t.exports=a.locals);var n=i("4f06").default;n("4e3c5f56",a,!0,{sourceMap:!1,shadowMode:!1})}}]);