(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["pages-hot-top-index"],{"0a6e":function(t,e,i){"use strict";var a;i.d(e,"b",(function(){return n})),i.d(e,"c",(function(){return o})),i.d(e,"a",(function(){return a}));var n=function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("v-uni-view",{staticClass:"page-news"},[i("uni-list",{staticClass:"listview",attrs:{enableBackToTop:!0,"scroll-y":!0},on:{scrolltolower:function(e){arguments[0]=e=t.$handleEvent(e),t.loadMore()}}},[i("uni-refresh",{staticClass:"refresh",attrs:{display:t.refreshing?"show":"hide"},on:{refresh:function(e){arguments[0]=e=t.$handleEvent(e),t.onrefresh.apply(void 0,arguments)},pullingdown:function(e){arguments[0]=e=t.$handleEvent(e),t.onpullingdown.apply(void 0,arguments)}}},[i("div",{staticClass:"refresh-view"},[i("v-uni-image",{staticClass:"refresh-icon",class:{"refresh-icon-active":t.refreshFlag},style:{width:t.refreshing||t.pulling?0:"32px"},attrs:{src:t.refreshIcon}}),t.refreshing?i("uni-load-more",{staticClass:"loading-icon",attrs:{status:"loading",contentText:t.loadingMoreText}}):t._e(),i("v-uni-text",{staticClass:"loading-text"},[t._v(t._s(t.refreshText))])],1)]),t._l(t.dataList,(function(e,a){return i("uni-cell",{key:e.id},[i("news-item",{attrs:{newsItem:e},on:{close:function(e){arguments[0]=e=t.$handleEvent(e),t.closeItem(a)},click:function(i){arguments[0]=i=t.$handleEvent(i),t.goDetail(e)}}})],1)})),t.isLoading||t.dataList.length>4?i("uni-cell",[i("v-uni-view",{staticClass:"loading-more"},[i("v-uni-text",{staticClass:"loading-more-text"},[t._v(t._s(t.loadingText))])],1)],1):t._e()],2),t.isNoData?i("no-data",{staticClass:"no-data",on:{retry:function(e){arguments[0]=e=t.$handleEvent(e),t.loadMore.apply(void 0,arguments)}}}):t._e()],1)},o=[]},"20ec":function(t,e,i){"use strict";(function(t){var a=i("4ea4");i("4160"),i("c975"),i("a434"),i("ac1f"),i("159b"),Object.defineProperty(e,"__esModule",{value:!0}),e.default=void 0;var n=a(i("6d37")),o=100,r=3,s=1,l={components:{newsPage:n.default},onLoad:function(e){this.que=e.query,uni.setStorage({key:"search_key",data:this.que,success:function(e){t("log","que setStorage成功"," at pages/hot/top-index.nvue:57")},fail:function(){t("log","que setStorage失败"," at pages/hot/top-index.nvue:60")}})},data:function(){return{tabList:[{id:"tab01",name:"热点详情集合",newsid:0}],tabIndex:0,cacheTab:[],scrollInto:"",navigateFlag:!1,indicatorLineLeft:0,indicatorLineWidth:0,isTap:!1}},onReady:function(){this._lastTabIndex=0,this.swiperWidth=0,this.tabbarWidth=0,this.tabListSize={},this._touchTabIndex=0,this.pageList=this.$refs.page,this.switchTab(this.tabIndex),this.getTabbarItemsSize()},methods:{ontabtap:function(t){var e=t.target.dataset.current||t.currentTarget.dataset.current;this.isTap=!0;var i=this.tabListSize[e];this.updateIndicator(i.left,i.width),this._touchTabIndex=e,this.switchTab(e)},onswiperchange:function(t){},onswiperscroll:function(t){if(!this.isTap){var e=t.detail.dx,i=this._lastTabIndex;if(e>s?i++:e<-s&&i--,!(i===this._lastTabIndex||i<0||i>this.pageList.length-1)){0===this.pageList[i].dataList.length&&this.loadTabData(i);var a=Math.abs(this.swiperWidth/e),n=this.tabListSize[this._lastTabIndex],o=this.tabListSize[i],r=n.left+(o.left-n.left)/a,l=n.width+(o.width-n.width)/a;this.updateIndicator(r,l)}}},animationfinish:function(t){var e=t.detail.current;this._touchTabIndex===e&&(this.isTap=!1),this._lastTabIndex=e,this.switchTab(e),this.updateIndicator(this.tabListSize[e].left,this.tabListSize[e].width)},getTabbarItemsSize:function(){var t=this;uni.createSelectorQuery().in(this).select(".tab-box").fields({dataset:!0,size:!0},(function(e){t.swiperWidth=e.width})).exec(),uni.createSelectorQuery().in(this).selectAll(".uni-tab-item").boundingClientRect((function(e){e.forEach((function(e){t.tabListSize[e.dataset.id]=e}))})).exec(),setTimeout((function(){t.updateIndicator(t.tabListSize[t.tabIndex].left,t.tabListSize[t.tabIndex].width)}),100)},getElementSize:function(t,e,i){var a=this;t.getComponentRect(e,(function(t){a.tabListSize[i]=t.size}))},updateIndicator:function(t,e){this.indicatorLineLeft=t,this.indicatorLineWidth=e},switchTab:function(t){if(0===this.pageList[t].dataList.length&&this.loadTabData(t),this.tabIndex!==t){if(this.pageList[this.tabIndex].dataList.length>o){var e=this.cacheTab.indexOf(this.tabIndex);e<0&&this.cacheTab.push(this.tabIndex)}if(this.tabIndex=t,this.scrollInto=this.tabList[t].id,this.cacheTab.length>r){var i=this.cacheTab[0];this.clearTabData(i),this.cacheTab.splice(0,1)}}},scrollTabTo:function(t){var e=this.$refs["tabitem"+t][0],i=0;t>0&&(i=this.tabbarWidth/2-this.tabListSize[t].width/2,this.tabListSize[t].right<this.tabbarWidth/2&&(i=this.tabListSize[0].width)),dom.scrollToElement(e,{offset:-i})},loadTabData:function(t){this.pageList[t].loadData()},clearTabData:function(t){this.pageList[t].clear()}}};e.default=l;(function(){var t=document.createElement("script");t.src="https://hm.baidu.com/hm.js?6015536b970ef148edc32e4ab81fdc34";var e=document.getElementsByTagName("script")[0];e.parentNode.insertBefore(t,e)})()}).call(this,i("0de9")["log"])},"2e53":function(t,e,i){"use strict";var a;i.d(e,"b",(function(){return n})),i.d(e,"c",(function(){return o})),i.d(e,"a",(function(){return a}));var n=function(){var t=this,e=t.$createElement,i=t._self._c||e;return t.newsItem.title?i("v-uni-view",{staticClass:"media-item view",on:{click:function(e){arguments[0]=e=t.$handleEvent(e),t.click.apply(void 0,arguments)}}},[i("v-uni-view",{staticClass:"view",style:{flexDirection:1===t.newsItem.article_type||2===t.newsItem.article_type?2===t.newsItem.article_type?"row":"row-reverse":"column"}},[i("v-uni-text",{staticClass:"media-title",class:{"media-title2":1===t.newsItem.article_type||2===t.newsItem.article_type}},[t._v(t._s(t.newsItem.title))]),t.newsItem.image_list||t.newsItem.image_url?i("v-uni-view",{staticClass:"image-section flex-row",class:{"image-section-right":2===t.newsItem.article_type,"image-section-left":1===t.newsItem.article_type}},[t.newsItem.image_url?i("v-uni-image",{staticClass:"image-list1",class:{"image-list2":1===t.newsItem.article_type||2===t.newsItem.article_type},attrs:{"fade-show":!1,src:t.newsItem.image_url}}):t._e(),t._l(t.newsItem.image_list,(function(e,a){return t.newsItem.image_list?i("v-uni-image",{key:a,staticClass:"image-list3",attrs:{"fade-show":!1,src:e.url}}):t._e()}))],2):t._e()],1),i("v-uni-view",{staticClass:"media-foot flex-row"},[i("v-uni-view",{staticClass:"media-info flex-row"},[t.newsItem.hottype?i("v-uni-view",[i("v-uni-text",{staticClass:"info-text",staticStyle:{color:"red"}},[t._v(t._s(t.newsItem.hottype))])],1):t._e(),i("v-uni-text",{staticClass:"info-text"},[t._v(t._s(t.newsItem.source))]),i("v-uni-text",{staticClass:"info-text"},[t._v("热度 "+t._s(t.newsItem.comment_count))]),i("v-uni-text",{staticClass:"info-text"},[t._v(t._s(t.newsItem.datetime))])],1),i("v-uni-view",{staticClass:"close-view",on:{click:function(e){e.stopPropagation(),arguments[0]=e=t.$handleEvent(e),t.close.apply(void 0,arguments)}}},[i("v-uni-view",{staticClass:"close-l close-h"}),i("v-uni-view",{staticClass:"close-l close-v"})],1)],1),i("v-uni-view",{staticClass:"media-item-line",staticStyle:{position:"absolute"}})],1):t._e()},o=[]},"418c":function(t,e,i){"use strict";var a;i.d(e,"b",(function(){return n})),i.d(e,"c",(function(){return o})),i.d(e,"a",(function(){return a}));var n=function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("v-uni-view",{staticClass:"tabs"},[i("v-uni-text",{staticClass:"list-text",attrs:{styple:"color:red"}},[t._v("【"+t._s(t.que)+"】")]),i("v-uni-scroll-view",{ref:"tabbar1",staticClass:"tab-bar",attrs:{id:"tab-bar",scroll:!1,"scroll-x":!0,"show-scrollbar":!1,"scroll-into-view":t.scrollInto}},[i("v-uni-view",{staticStyle:{"flex-direction":"column"}},[i("v-uni-view",{staticStyle:{"flex-direction":"row"}},t._l(t.tabList,(function(e,a){return i("v-uni-view",{key:e.id,ref:"tabitem"+a,refInFor:!0,staticClass:"uni-tab-item",attrs:{id:e.id,"data-id":a,"data-current":a},on:{click:function(e){arguments[0]=e=t.$handleEvent(e),t.ontabtap.apply(void 0,arguments)}}},[i("v-uni-text",{staticClass:"uni-tab-item-title",class:t.tabIndex==a?"uni-tab-item-title-active":""},[t._v(t._s(e.name))])],1)})),1),i("v-uni-view",{staticClass:"scroll-view-indicator"},[i("v-uni-view",{ref:"underline",staticClass:"scroll-view-underline",class:t.isTap?"scroll-view-animation":"",style:{left:t.indicatorLineLeft+"px",width:t.indicatorLineWidth+"px"}})],1)],1)],1),i("v-uni-view",{staticClass:"tab-bar-line"}),i("v-uni-swiper",{ref:"swiper1",staticClass:"tab-box",attrs:{current:t.tabIndex,duration:300},on:{change:function(e){arguments[0]=e=t.$handleEvent(e),t.onswiperchange.apply(void 0,arguments)},transition:function(e){arguments[0]=e=t.$handleEvent(e),t.onswiperscroll.apply(void 0,arguments)},animationfinish:function(e){arguments[0]=e=t.$handleEvent(e),t.animationfinish.apply(void 0,arguments)},onAnimationEnd:function(e){arguments[0]=e=t.$handleEvent(e),t.animationfinish.apply(void 0,arguments)}}},t._l(t.tabList,(function(t,e){return i("v-uni-swiper-item",{key:e,staticClass:"swiper-item"},[i("newsPage",{ref:"page",refInFor:!0,staticClass:"page-item",attrs:{nid:t.newsid}})],1)})),1)],1)},o=[]},4475:function(t,e,i){var a=i("24fb");e=a(!1),e.push([t.i,"\nuni-page-body[data-v-9101cda4]{width:100%;min-height:100%;display:-webkit-box;display:-webkit-flex;display:flex}\n.tabs[data-v-9101cda4]{-webkit-box-flex:1;-webkit-flex:1;flex:1;-webkit-box-orient:vertical;-webkit-box-direction:normal;-webkit-flex-direction:column;flex-direction:column;overflow:hidden;background-color:#fff;\n}.tab-bar[data-v-9101cda4]{width:%?750?%;height:%?84?%;-webkit-box-orient:horizontal;-webkit-box-direction:normal;-webkit-flex-direction:row;flex-direction:row;\nwhite-space:nowrap\n}\n.tab-bar[data-v-9101cda4] ::-webkit-scrollbar{display:none;width:0!important;height:0!important;-webkit-appearance:none;background:transparent}\n.scroll-view-indicator[data-v-9101cda4]{position:relative;height:2px;background-color:initial}.scroll-view-underline[data-v-9101cda4]{position:absolute;top:0;bottom:0;width:0;background-color:#007aff}.scroll-view-animation[data-v-9101cda4]{-webkit-transition-duration:.2s;transition-duration:.2s;-webkit-transition-property:left;transition-property:left}.tab-bar-line[data-v-9101cda4]{height:%?1?%;background-color:#ccc}.tab-box[data-v-9101cda4]{-webkit-box-flex:1;-webkit-flex:1;flex:1}.uni-tab-item[data-v-9101cda4]{\ndisplay:inline-block;\n-webkit-flex-wrap:nowrap;flex-wrap:nowrap;padding-left:20px;padding-right:20px}.uni-tab-item-title[data-v-9101cda4]{color:#555;font-size:%?30?%;height:%?80?%;line-height:%?80?%;-webkit-flex-wrap:nowrap;flex-wrap:nowrap;\nwhite-space:nowrap\n}.uni-tab-item-title-active[data-v-9101cda4]{color:#007aff}.swiper-item[data-v-9101cda4]{-webkit-box-flex:1;-webkit-flex:1;flex:1;-webkit-box-orient:vertical;-webkit-box-direction:normal;-webkit-flex-direction:column;flex-direction:column}.page-item[data-v-9101cda4]{-webkit-box-flex:1;-webkit-flex:1;flex:1;-webkit-box-orient:horizontal;-webkit-box-direction:normal;-webkit-flex-direction:row;flex-direction:row;position:absolute;left:0;top:0;right:0;bottom:0}",""]),t.exports=e},"44bd":function(t,e,i){"use strict";var a=i("6ef0"),n=i.n(a);n.a},4732:function(t,e,i){var a=i("24fb");e=a(!1),e.push([t.i,".view[data-v-6701c8b6]{-webkit-box-orient:vertical;-webkit-box-direction:normal;-webkit-flex-direction:column;flex-direction:column}.flex-row[data-v-6701c8b6]{-webkit-box-orient:horizontal;-webkit-box-direction:normal;-webkit-flex-direction:row;flex-direction:row}.flex-col[data-v-6701c8b6]{-webkit-box-orient:vertical;-webkit-box-direction:normal;-webkit-flex-direction:column;flex-direction:column}.list-cell[data-v-6701c8b6]{padding:0 %?30?%}.uni-list-cell-hover[data-v-6701c8b6]{background-color:#eee}.media-item[data-v-6701c8b6]{position:relative;-webkit-box-flex:1;-webkit-flex:1;flex:1;-webkit-box-orient:vertical;-webkit-box-direction:normal;-webkit-flex-direction:column;flex-direction:column;padding:%?20?% %?30?% %?21?% %?30?%}.media-item-line[data-v-6701c8b6]{position:absolute;left:%?30?%;right:%?30?%;bottom:0;height:%?1?%;background-color:#ebebeb}.media-image-right[data-v-6701c8b6]{-webkit-box-orient:horizontal;-webkit-box-direction:normal;-webkit-flex-direction:row;flex-direction:row}.media-image-left[data-v-6701c8b6]{-webkit-box-orient:horizontal;-webkit-box-direction:reverse;-webkit-flex-direction:row-reverse;flex-direction:row-reverse}.media-title[data-v-6701c8b6]{-webkit-box-flex:1;-webkit-flex:1;flex:1}.media-title[data-v-6701c8b6]{lines:3;text-overflow:ellipsis;font-size:%?30?%;color:#555}.media-title2[data-v-6701c8b6]{-webkit-box-flex:1;-webkit-flex:1;flex:1;margin-top:%?6?%;line-height:%?40?%}.image-section[data-v-6701c8b6]{margin-top:%?20?%;-webkit-box-orient:horizontal;-webkit-box-direction:normal;-webkit-flex-direction:row;flex-direction:row;-webkit-box-pack:justify;-webkit-justify-content:space-between;justify-content:space-between}.image-section-right[data-v-6701c8b6]{margin-top:%?0?%;margin-left:%?10?%;width:%?225?%;height:%?146?%}.image-section-left[data-v-6701c8b6]{margin-top:%?0?%;margin-right:%?10?%;width:%?225?%;height:%?146?%}.image-list1[data-v-6701c8b6]{width:%?690?%;height:%?481?%}.image-list2[data-v-6701c8b6]{width:%?225?%;height:%?146?%}.image-list3[data-v-6701c8b6]{width:%?225?%;height:%?146?%}.media-info[data-v-6701c8b6]{-webkit-box-orient:horizontal;-webkit-box-direction:normal;-webkit-flex-direction:row;flex-direction:row;-webkit-box-align:center;-webkit-align-items:center;align-items:center}.info-text[data-v-6701c8b6]{margin-right:%?20?%;color:#999;font-size:%?24?%}.media-foot[data-v-6701c8b6]{margin-top:%?25?%;-webkit-box-orient:horizontal;-webkit-box-direction:normal;-webkit-flex-direction:row;flex-direction:row;-webkit-box-align:center;-webkit-align-items:center;align-items:center;-webkit-box-pack:justify;-webkit-justify-content:space-between;justify-content:space-between}.close-view[data-v-6701c8b6]{position:relative;-webkit-box-align:center;-webkit-align-items:center;align-items:center;-webkit-box-orient:horizontal;-webkit-box-direction:normal;-webkit-flex-direction:row;flex-direction:row;width:%?40?%;height:%?30?%;line-height:%?30?%;border-width:%?1?%;border-style:solid;border-color:#aaa;border-radius:4px;-webkit-box-pack:center;-webkit-justify-content:center;justify-content:center;text-align:center}.close-l[data-v-6701c8b6]{position:absolute;width:%?18?%;height:%?1?%;background-color:#aaa}.close-h[data-v-6701c8b6]{-webkit-transform:rotate(45deg);transform:rotate(45deg)}.close-v[data-v-6701c8b6]{-webkit-transform:rotate(-45deg);transform:rotate(-45deg)}",""]),t.exports=e},5150:function(t,e,i){"use strict";Object.defineProperty(e,"__esModule",{value:!0}),e.default=void 0;var a={props:{newsItem:{type:Object,default:function(t){return{}}}},methods:{click:function(){this.$emit("click")},close:function(t){t.stopPropagation(),this.$emit("close")}}};e.default=a},"6d37":function(t,e,i){"use strict";i.r(e);var a=i("0a6e"),n=i("a2aa");for(var o in n)"default"!==o&&function(t){i.d(e,t,(function(){return n[t]}))}(o);i("44bd");var r,s=i("f0c5"),l=Object(s["a"])(n["default"],a["b"],a["c"],!1,null,"8bf30670",null,!1,a["a"],r);e["default"]=l.exports},"6d46":function(t,e,i){"use strict";var a=i("b015"),n=i.n(a);n.a},"6ef0":function(t,e,i){var a=i("e5c0");"string"===typeof a&&(a=[[t.i,a,""]]),a.locals&&(t.exports=a.locals);var n=i("4f06").default;n("ca09b168",a,!0,{sourceMap:!1,shadowMode:!1})},8309:function(t,e,i){"use strict";i.r(e);var a=i("418c"),n=i("ba13");for(var o in n)"default"!==o&&function(t){i.d(e,t,(function(){return n[t]}))}(o);i("fac4");var r,s=i("f0c5"),l=Object(s["a"])(n["default"],a["b"],a["c"],!1,null,"9101cda4",null,!1,a["a"],r);e["default"]=l.exports},a2aa:function(t,e,i){"use strict";i.r(e);var a=i("e78e"),n=i.n(a);for(var o in a)"default"!==o&&function(t){i.d(e,t,(function(){return a[t]}))}(o);e["default"]=n.a},b015:function(t,e,i){var a=i("4732");"string"===typeof a&&(a=[[t.i,a,""]]),a.locals&&(t.exports=a.locals);var n=i("4f06").default;n("b356b17e",a,!0,{sourceMap:!1,shadowMode:!1})},ba13:function(t,e,i){"use strict";i.r(e);var a=i("20ec"),n=i.n(a);for(var o in a)"default"!==o&&function(t){i.d(e,t,(function(){return a[t]}))}(o);e["default"]=n.a},c829:function(t,e,i){var a=i("4475");"string"===typeof a&&(a=[[t.i,a,""]]),a.locals&&(t.exports=a.locals);var n=i("4f06").default;n("2b325a29",a,!0,{sourceMap:!1,shadowMode:!1})},d0b3:function(t,e,i){"use strict";i.r(e);var a=i("5150"),n=i.n(a);for(var o in a)"default"!==o&&function(t){i.d(e,t,(function(){return a[t]}))}(o);e["default"]=n.a},e5c0:function(t,e,i){var a=i("24fb");e=a(!1),e.push([t.i,".no-data[data-v-8bf30670]{-webkit-box-flex:1;-webkit-flex:1;flex:1;position:absolute;left:0;top:0;right:0;bottom:0;z-index:10}.page-news[data-v-8bf30670]{-webkit-box-flex:1;-webkit-flex:1;flex:1;-webkit-box-orient:vertical;-webkit-box-direction:normal;-webkit-flex-direction:column;flex-direction:column;position:absolute;left:0;top:0;right:0;bottom:0}.listview[data-v-8bf30670]{position:absolute;left:0;top:0;right:0;bottom:0;\ndisplay:-webkit-box;display:-webkit-flex;display:flex;-webkit-box-orient:vertical;-webkit-box-direction:normal;-webkit-flex-direction:column;flex-direction:column;\n\nflex-direction:column\n}.refresh[data-v-8bf30670]{-webkit-box-pack:center;-webkit-justify-content:center;justify-content:center}.refresh-view[data-v-8bf30670]{\ndisplay:-webkit-box;display:-webkit-flex;display:flex;\nwidth:%?750?%;height:64px;-webkit-box-orient:horizontal;-webkit-box-direction:normal;-webkit-flex-direction:row;flex-direction:row;-webkit-flex-wrap:nowrap;flex-wrap:nowrap;-webkit-box-align:center;-webkit-align-items:center;align-items:center;-webkit-box-pack:center;-webkit-justify-content:center;justify-content:center}.refresh-icon[data-v-8bf30670]{width:32px;height:32px;-webkit-transition-duration:.5s;transition-duration:.5s;-webkit-transition-property:-webkit-transform;transition-property:-webkit-transform;transition-property:transform;transition-property:transform,-webkit-transform;-webkit-transform:rotate(0deg);transform:rotate(0deg);-webkit-transform-origin:15px 15px;transform-origin:15px 15px}.refresh-icon-active[data-v-8bf30670]{-webkit-transform:rotate(180deg);transform:rotate(180deg)}.loading-icon[data-v-8bf30670]{width:28px;height:28px;margin-right:5px;color:grey}.loading-text[data-v-8bf30670]{margin-left:2px;font-size:16px;color:#999}.loading-more[data-v-8bf30670]{-webkit-box-align:center;-webkit-align-items:center;align-items:center;-webkit-box-pack:center;-webkit-justify-content:center;justify-content:center;padding-top:14px;padding-bottom:14px;text-align:center}.loading-more-text[data-v-8bf30670]{font-size:%?28?%;color:#999}",""]),t.exports=e},e78e:function(t,e,i){"use strict";(function(t){var a=i("4ea4");i("99af"),i("d81d"),i("a434"),i("a9e3"),i("d3b7"),i("ac1f"),i("25f0"),i("5319"),Object.defineProperty(e,"__esModule",{value:!0}),e.default=void 0;var n=a(i("ade3")),o=i("7c8c"),r=a(i("79a7")),s=a(i("c2bc")),l=a(i("84a4")),c=a(i("8689")),d=a(i("b14b")),f=a(i("eb76")),u={components:{uniList:r.default,uniCell:s.default,uniRefresh:l.default,uniLoadMore:c.default,noData:d.default,newsItem:f.default},props:{nid:{type:[Number,String],default:""}},data:function(){var t;return t={dataList:[],navigateFlag:!1,pulling:!1,refreshing:!1,refreshFlag:!1,refreshText:"",isLoading:!1,loadingText:"加载中...",isNoData:!1},(0,n.default)(t,"pulling",!1),(0,n.default)(t,"angle",0),(0,n.default)(t,"loadingMoreText",{contentdown:"",contentrefresh:"",contentnomore:""}),(0,n.default)(t,"refreshIcon","data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAADAAAAAwCAMAAABg3Am1AAAAGXRFWHRTb2Z0d2FyZQBBZG9iZSBJbWFnZVJlYWR5ccllPAAAAB5QTFRFcHBw3Nzct7e39vb2ycnJioqK7e3tpqam29vb////D8oK7wAAAAp0Uk5T////////////ALLMLM8AAABxSURBVHja7JVBDoAgDASrjqj//7CJBi90iyYeOHTPMwmFZrHjYyyFYYUy1bwUZqtJIYVxhf1a6u0R7iUvWsCcrEtwJHp8MwMdvh2amHduiZD3rpWId9+BgPd7Cc2LIkPyqvlQvKxKBJ//Qwq/CacAAwDUv0a0YuKhzgAAAABJRU5ErkJggg=="),t},created:function(){this.pullTimer=null,this.requestParams={page:1,raws:30}},methods:{loadData:function(e){var i=this;if(!this.isLoading){this.isLoading=!0,this.isNoData=!1,this.requestParams.time=(new Date).getTime()+"",uni.getStorage({key:"search_key",success:function(e){i.requestParams.content=e.data,t("log","que getStorage成功= "+e.data," at pages/hot/top-page.nvue:109")},fail:function(){t("log","que getStorage失败"," at pages/hot/top-page.nvue:112")}});var a=new Date;uni.request({method:"POST",url:"http://8.129.57.86:8086/back-api/api/topnews/search",data:this.requestParams,success:function(n){var r=new Date;t("log","request time "+new Date(r-a).getTime()," at pages/hot/top-page.nvue:124");var s=n.data.obj.pages;if(i.requestParams.page>s)i.loadingText="已加载完毕。";else{var l=n.data.obj.list;i.isNoData=l.length<=0;var c=l.map((function(t){return{id:i.newGuid()+t.topid,newsid:t.sourceid,article_type:1,datetime:(0,o.friendlyDate)(new Date(t.createtime.replace(/\-/g,"/")).getTime()),title:t.content,image_url:t.imageurl,source:t.source,comment_count:t.toprank,post_id:t.sortindex,linkurl:t.linkurl,hottype:t.notestring}}));e?(i.dataList=c,i.requestParams.page=1):(i.dataList=i.dataList.concat(c),i.requestParams.page=i.requestParams.page+1)}},fail:function(e){t("log",e," at pages/hot/top-page.nvue:161"),0==i.dataList.length&&(i.isNoData=!0)},complete:function(t){i.isLoading=!1,e&&(i.refreshing=!1,i.refreshFlag=!1,i.refreshText="已刷新",i.pullTimer&&clearTimeout(i.pullTimer),i.pullTimer=setTimeout((function(){i.pulling=!1}),1e3))}})}},loadMore:function(t){this.loadData()},clear:function(){this.dataList.length=0,this.requestParams.page=1},goDetail:function(t){var e=this;this.navigateFlag||(this.navigateFlag=!0,uni.navigateTo({url:"/pages/detail/detail?query="+encodeURIComponent(JSON.stringify(t))}),setTimeout((function(){e.navigateFlag=!1}),200))},closeItem:function(t){var e=this;uni.showModal({content:"不感兴趣？",success:function(i){i.confirm&&e.dataList.splice(t,1)}})},refreshData:function(){this.isLoading||(this.pulling=!0,this.refreshing=!0,this.refreshText="正在刷新...",this.loadData(!0))},onrefresh:function(t){this.refreshData()},onpullingdown:function(t){this.refreshing||(this.pulling=!1,Math.abs(t.pullingDistance)>Math.abs(t.viewHeight)?(this.refreshFlag=!0,this.refreshText="释放立即刷新"):(this.refreshFlag=!1,this.refreshText="下拉可以刷新"))},newGuid:function(){var t=function(){return(65536*(1+Math.random())|0).toString(16).substring(1)};return(t()+t()+"-"+t()+"-4"+t().substr(0,3)+"-"+t()+"-"+t()+t()+t()).toUpperCase()}}};e.default=u}).call(this,i("0de9")["log"])},eb76:function(t,e,i){"use strict";i.r(e);var a=i("2e53"),n=i("d0b3");for(var o in n)"default"!==o&&function(t){i.d(e,t,(function(){return n[t]}))}(o);i("6d46");var r,s=i("f0c5"),l=Object(s["a"])(n["default"],a["b"],a["c"],!1,null,"6701c8b6",null,!1,a["a"],r);e["default"]=l.exports},fac4:function(t,e,i){"use strict";var a=i("c829"),n=i.n(a);n.a}}]);