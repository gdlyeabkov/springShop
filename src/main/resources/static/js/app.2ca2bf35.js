(function(e){function t(t){for(var r,a,s=t[0],u=t[1],l=t[2],d=0,b=[];d<s.length;d++)a=s[d],Object.prototype.hasOwnProperty.call(o,a)&&o[a]&&b.push(o[a][0]),o[a]=0;for(r in u)Object.prototype.hasOwnProperty.call(u,r)&&(e[r]=u[r]);i&&i(t);while(b.length)b.shift()();return c.push.apply(c,l||[]),n()}function n(){for(var e,t=0;t<c.length;t++){for(var n=c[t],r=!0,s=1;s<n.length;s++){var u=n[s];0!==o[u]&&(r=!1)}r&&(c.splice(t--,1),e=a(a.s=n[0]))}return e}var r={},o={app:0},c=[];function a(t){if(r[t])return r[t].exports;var n=r[t]={i:t,l:!1,exports:{}};return e[t].call(n.exports,n,n.exports,a),n.l=!0,n.exports}a.m=e,a.c=r,a.d=function(e,t,n){a.o(e,t)||Object.defineProperty(e,t,{enumerable:!0,get:n})},a.r=function(e){"undefined"!==typeof Symbol&&Symbol.toStringTag&&Object.defineProperty(e,Symbol.toStringTag,{value:"Module"}),Object.defineProperty(e,"__esModule",{value:!0})},a.t=function(e,t){if(1&t&&(e=a(e)),8&t)return e;if(4&t&&"object"===typeof e&&e&&e.__esModule)return e;var n=Object.create(null);if(a.r(n),Object.defineProperty(n,"default",{enumerable:!0,value:e}),2&t&&"string"!=typeof e)for(var r in e)a.d(n,r,function(t){return e[t]}.bind(null,r));return n},a.n=function(e){var t=e&&e.__esModule?function(){return e["default"]}:function(){return e};return a.d(t,"a",t),t},a.o=function(e,t){return Object.prototype.hasOwnProperty.call(e,t)},a.p="/";var s=window["webpackJsonp"]=window["webpackJsonp"]||[],u=s.push.bind(s);s.push=t,s=s.slice();for(var l=0;l<s.length;l++)t(s[l]);var i=u;c.push([0,"chunk-vendors"]),n()})({0:function(e,t,n){e.exports=n("56d7")},1:function(e,t){},10:function(e,t){},1036:function(e,t,n){"use strict";n("a845")},11:function(e,t){},12:function(e,t){},13:function(e,t){},"13fa":function(e,t,n){},14:function(e,t){},2:function(e,t){},3:function(e,t){},4:function(e,t){},"41d0":function(e,t,n){"use strict";n("c715")},"43dd":function(e,t,n){"use strict";n("87bf")},"4a71":function(e,t,n){},5:function(e,t){},"56d7":function(e,t,n){"use strict";n.r(t);n("e260"),n("e6cf"),n("cca6"),n("a79d");var r=n("7a23");function o(e,t){var n=Object(r["w"])("router-view");return Object(r["p"])(),Object(r["d"])(n)}const c={};c.render=o;var a=c,s=n("6c02"),u=(n("b0c0"),Object(r["E"])("data-v-c0b8e152"));Object(r["s"])("data-v-c0b8e152");var l={class:"customCardGroup"},i={class:"card-header bg-warning"},d={class:"card-body"},b={class:"card-title"},m={key:1,style:{color:"white","font-weight":"bold"}};Object(r["q"])();var f=u((function(e,t,n,o,c,a){var s=Object(r["w"])("Header"),f=Object(r["w"])("router-link"),g=Object(r["w"])("Footer");return Object(r["p"])(),Object(r["d"])(r["a"],null,[Object(r["g"])("div",null,[Object(r["g"])(s,{useremail:c.useremail,auth:!0},null,8,["useremail"]),Object(r["g"])("div",l,[c.allProducts.length>=1?(Object(r["p"])(!0),Object(r["d"])(r["a"],{key:0},Object(r["v"])(c.allProducts,(function(t){return Object(r["p"])(),Object(r["d"])("div",{class:"card",key:t.id},[Object(r["g"])("h5",i,[e.isAuth?(Object(r["p"])(),Object(r["d"])(f,{key:0,to:{name:"product",params:{productID:t.id},query:{useremail:c.useremail}}},{default:u((function(){return[Object(r["f"])(Object(r["y"])(t.name),1)]})),_:2},1032,["to"])):(Object(r["p"])(),Object(r["d"])(f,{key:1,to:{name:"product",params:{productID:t.id}}},{default:u((function(){return[Object(r["f"])(Object(r["y"])(t.name),1)]})),_:2},1032,["to"]))]),Object(r["g"])("div",d,[Object(r["g"])("h5",b,Object(r["y"])(t.price)+"$",1),Object(r["g"])("a",{onClick:function(e){return a.addToBucket(t)},class:"btn btn-danger"},"Добавить в корзину",8,["onClick"])])])})),128)):c.allProducts.length<=0?(Object(r["p"])(),Object(r["d"])("div",m," Список товаров пуст ")):Object(r["e"])("",!0)])]),Object(r["g"])(g)],64)})),g=n("1da1"),p=(n("96cf"),n("d3b7"),n("99af"),n("caad"),n("2532"),{class:"pos-f-t"}),O={ref:"customcollapsepanel",class:"customcollapsepanel collapse",id:"navbarToggleExternalContent"},h={class:"customcollapse bg-dark p-4"},j={key:0},v={class:"navbar-nav"},y={class:"nav-item"},w=Object(r["f"])(" Вход "),k=Object(r["g"])("br",{style:{clear:"both"}},null,-1),x={class:"nav-item"},R=Object(r["f"])(" Регистрация "),q={key:0},S={class:"nav-item"},C=Object(r["f"])(" Главная "),$={class:"nav-item"},T=Object(r["f"])(" Корзина "),U={class:"badge bg-danger"},_={key:1,style:{float:"right"}},E={class:"badge bg-danger"},I={class:"badge bg-danger"},H=Object(r["f"])("+"),B={class:"nav-item"},N=Object(r["f"])(" Главная "),P={class:"nav-item"},F=Object(r["f"])(" Корзина "),A={class:"badge bg-danger"},L={class:"navbar navbar-dark bg-dark"},J=Object(r["g"])("span",{class:"navbar-toggler-icon"},null,-1),G=Object(r["g"])("a",{class:"navbar-brand",href:"#"},"Market Town",-1),D={class:"navbar-nav"},V={key:0},M={key:0},K={class:"nav-item"},z=Object(r["f"])(" Вход "),W=Object(r["g"])("br",{style:{clear:"both"}},null,-1),Q={class:"nav-item"},X=Object(r["f"])(" Регистрация "),Y={key:1},Z={class:"nav-item"},ee=Object(r["f"])(" Главная "),te={class:"nav-item"},ne=Object(r["f"])(" Корзина "),re={class:"badge bg-danger"};function oe(e,t,n,o,c,a){var s=Object(r["w"])("router-link");return Object(r["p"])(),Object(r["d"])("div",p,[Object(r["g"])("div",O,[Object(r["g"])("div",h,[n.auth?n.auth?(Object(r["p"])(),Object(r["d"])("div",_,[Object(r["g"])("li",null,[Object(r["g"])("span",E,[Object(r["g"])("a",{class:"badge bg-danger",style:{cursor:"pointer"},onClick:t[1]||(t[1]=function(e){return a.logoutUser()})},"Выйти")])]),Object(r["g"])("li",null,[Object(r["g"])("span",I,[Object(r["g"])(s,{style:{color:"white","text-decoration":"none"},to:{name:"Amount",query:{useremail:n.useremail,amount:0}}},{default:Object(r["C"])((function(){return[H]})),_:1},8,["to"])])]),Object(r["g"])("li",B,[Object(r["g"])(s,{style:{color:"red"},to:{name:"Home"}},{default:Object(r["C"])((function(){return[N]})),_:1})]),Object(r["g"])("li",P,[Object(r["g"])(s,{style:{color:"red"},class:"nav-item",to:{name:"Bucket",query:{useremail:n.useremail}}},{default:Object(r["C"])((function(){return[F]})),_:1},8,["to"])]),Object(r["g"])("li",null,[Object(r["g"])("span",A,Object(r["y"])(n.useremail),1)])])):Object(r["e"])("",!0):(Object(r["p"])(),Object(r["d"])("div",j,[Object(r["g"])("ul",v,[Object(r["g"])("div",null,[Object(r["g"])("li",y,[Object(r["g"])(s,{style:{color:"red",float:"right"},class:"nav-item",to:{name:"UsersLogin"}},{default:Object(r["C"])((function(){return[w]})),_:1})]),k,Object(r["g"])("li",x,[Object(r["g"])(s,{style:{color:"red",float:"right"},class:"nav-item",to:{name:"UsersRegistry"}},{default:Object(r["C"])((function(){return[R]})),_:1})]),n.auth?(Object(r["p"])(),Object(r["d"])("div",q,[Object(r["g"])("li",S,[Object(r["g"])(s,{to:{name:"Home"}},{default:Object(r["C"])((function(){return[C]})),_:1})]),Object(r["g"])("li",$,[Object(r["g"])(s,{class:"nav-item",to:{name:"Bucket",query:{useremail:n.useremail}}},{default:Object(r["C"])((function(){return[T]})),_:1},8,["to"])]),Object(r["g"])("li",null,[Object(r["g"])("span",U,Object(r["y"])(n.useremail),1)])])):Object(r["e"])("",!0)])])]))])],512),Object(r["g"])("nav",L,[Object(r["g"])("button",{onClick:t[2]||(t[2]=function(e){return a.toggleSidebar()}),class:"customburger navbar-toggler",type:"button","data-toggle":"collapse","data-target":"#navbarToggleExternalContent","aria-controls":"navbarToggleExternalContent","aria-expanded":"false","aria-label":"Toggle navigation"},[J]),G,Object(r["g"])("ul",D,[c.burgerVisible?Object(r["e"])("",!0):(Object(r["p"])(),Object(r["d"])("div",V,[n.auth?n.auth?(Object(r["p"])(),Object(r["d"])("div",Y,[Object(r["g"])("li",Z,[Object(r["g"])(s,{to:{name:"Home"},style:{color:"red"}},{default:Object(r["C"])((function(){return[ee]})),_:1})]),Object(r["g"])("li",te,[Object(r["g"])(s,{class:"nav-item",to:{name:"Bucket",query:{useremail:n.useremail}},style:{color:"red"}},{default:Object(r["C"])((function(){return[ne]})),_:1},8,["to"])]),Object(r["g"])("li",null,[Object(r["g"])("span",re,Object(r["y"])(n.useremail),1)])])):Object(r["e"])("",!0):(Object(r["p"])(),Object(r["d"])("div",M,[Object(r["g"])("li",K,[Object(r["g"])(s,{style:{color:"red",float:"right"},class:"nav-item",to:{name:"UsersLogin"}},{default:Object(r["C"])((function(){return[z]})),_:1})]),W,Object(r["g"])("li",Q,[Object(r["g"])(s,{style:{color:"red",float:"right"},class:"nav-item",to:{name:"UsersRegistry"}},{default:Object(r["C"])((function(){return[X]})),_:1})])]))]))])])])}var ce=n("14b7"),ae={name:"Header",data:function(){return{burgerVisible:!1}},methods:{toggleSidebar:function(){this.burgerVisible=!this.burgerVisible,this.burgerVisible?this.$refs.customcollapsepanel.style="display: block;":this.burgerVisible||(this.$refs.customcollapsepanel.style="display: none;")},logoutUser:function(){window.localStorage.clear(),ce["sign"]({useremail:"custom@mail.ru"},"secret",{expiresIn:1}),this.$router.push({name:"UsersLogin"})}},props:{auth:{type:Boolean,default:!1},useremail:{type:String}}};n("41d0");ae.render=oe;var se=ae,ue=Object(r["E"])("data-v-b0f0f010");Object(r["s"])("data-v-b0f0f010");var le=Object(r["g"])("br",{style:{clear:"both"}},null,-1),ie={class:"bg-dark p-4 customfooter"},de={class:"",style:{color:"white","font-weight":"bold"}};Object(r["q"])();var be=ue((function(e,t,n,o,c,a){return Object(r["p"])(),Object(r["d"])(r["a"],null,[le,Object(r["g"])("div",ie,[Object(r["g"])("p",de,"© "+Object(r["y"])((new Date).toLocaleDateString()),1)])],64)})),me={name:"Footer"};n("f614");me.render=be,me.__scopeId="data-v-b0f0f010";var fe=me,ge={name:"Home",data:function(){return{allProducts:[],useremail:"",token:window.localStorage.getItem("markettowntoken")}},methods:{addToBucket:function(e){var t=this;return Object(g["a"])(regeneratorRuntime.mark((function n(){return regeneratorRuntime.wrap((function(n){while(1)switch(n.prev=n.next){case 0:fetch("http://localhost:8081/users/bucket/add?useremail=".concat(t.useremail,"&productname=").concat(e.name,"&productprice=").concat(e.price,"&productid=").concat(e.id),{mode:"cors",method:"GET"}).then((function(e){return e.body})).then((function(e){var t=e.getReader();return new ReadableStream({start:function(e){function n(){t.read().then((function(t){var r=t.done,o=t.value;if(r)return console.log("done",r),void e.close();e.enqueue(o),console.log(r,o),n()}))}n()}})})).then((function(e){return new Response(e,{headers:{"Content-Type":"text/html"}}).text()})).then(function(){var e=Object(g["a"])(regeneratorRuntime.mark((function e(n){return regeneratorRuntime.wrap((function(e){while(1)switch(e.prev=e.next){case 0:ce["verify"](t.token,"secret",(function(e,r){e?t.$router.push({name:"UsersLogin"}):JSON.parse(n).status.includes("OK")&&t.$router.push({name:"Bucket",query:{useremail:t.useremail}})}));case 1:case"end":return e.stop()}}),e)})));return function(t){return e.apply(this,arguments)}}());case 1:case"end":return n.stop()}}),n)})))()},toAmount:function(){}},mounted:function(){var e=this;return Object(g["a"])(regeneratorRuntime.mark((function t(){return regeneratorRuntime.wrap((function(t){while(1)switch(t.prev=t.next){case 0:null!==e.$route.query.redirectroute&&void 0!==e.$route.query.redirectroute?e.$route.query.redirectroute.includes("users/login")||e.$route.query.redirectroute.includes("users/register")?e.$router.push({path:e.$route.query.redirectroute}):e.$route.query.redirectroute.includes("users/login")||e.$route.query.redirectroute.includes("users/register")||e.$router.push({name:"Home"}):fetch("http://localhost:8081/home",{mode:"cors",method:"GET"}).then((function(e){return e.body})).then((function(e){var t=e.getReader();return new ReadableStream({start:function(e){function n(){t.read().then((function(t){var r=t.done,o=t.value;if(r)return console.log("done",r),void e.close();e.enqueue(o),console.log(r,o),n()}))}n()}})})).then((function(e){return new Response(e,{headers:{"Content-Type":"text/html"}}).text()})).then((function(t){console.log(JSON.parse(t)),ce["verify"](e.token,"secret",(function(n,r){n?e.$router.push({name:"UsersLogin"}):(e.allProducts=JSON.parse(t).allProducts,e.useremail=r.useremail)}))}));case 1:case"end":return t.stop()}}),t)})))()},components:{Header:se,Footer:fe}};n("a2aa");ge.render=f,ge.__scopeId="data-v-c0b8e152";var pe=ge,Oe=Object(r["E"])("data-v-41ec35a7");Object(r["s"])("data-v-41ec35a7");var he={class:"home"},je={class:"card",style:{width:"18rem"}},ve={class:"card-title"},ye={class:"card-header bg-warning"},we={class:"card-text"};Object(r["q"])();var ke=Oe((function(e,t,n,o,c,a){var s=Object(r["w"])("Header"),u=Object(r["w"])("Footer");return Object(r["p"])(),Object(r["d"])(r["a"],null,[Object(r["g"])("div",he,[Object(r["g"])(s,{auth:!0,useremail:e.useremail},null,8,["useremail"]),Object(r["g"])("div",je,[Object(r["g"])("div",ve,[Object(r["g"])("h5",ye,Object(r["y"])(c.product.name),1)]),Object(r["g"])("div",{class:"card-body","v-if":c.product.length},[Object(r["g"])("p",we,Object(r["y"])(c.product.price)+"$",1),Object(r["g"])("a",{onClick:t[1]||(t[1]=function(e){return a.addToBucket()}),class:"btn btn-danger"},"Добавить в корзину")],8,["v-if"])])]),Object(r["g"])(u)],64)})),xe={name:"Product",data:function(){return{product:{},token:window.localStorage.getItem("markettowntoken")}},methods:{addToBucket:function(){var e=this;fetch("http://localhost:8081/users/bucket/add?useremail=".concat(this.useremail,"&productname=").concat(this.product.name,"&productprice=").concat(this.product.price,"&productid=").concat(this.$route.params.productID),{mode:"cors",method:"GET"}).then((function(e){return e.body})).then((function(e){var t=e.getReader();return new ReadableStream({start:function(e){function n(){t.read().then((function(t){var r=t.done,o=t.value;if(r)return console.log("done",r),void e.close();e.enqueue(o),console.log(r,o),n()}))}n()}})})).then((function(e){return new Response(e,{headers:{"Content-Type":"text/html"}}).text()})).then(function(){var t=Object(g["a"])(regeneratorRuntime.mark((function t(n){return regeneratorRuntime.wrap((function(t){while(1)switch(t.prev=t.next){case 0:ce["verify"](e.token,"secret",(function(t,n){t?e.$router.push({name:"UsersLogin"}):e.$router.push({name:"Bucket",query:{useremail:n.useremail}})}));case 1:case"end":return t.stop()}}),t)})));return function(e){return t.apply(this,arguments)}}())}},mounted:function(){var e=this;return Object(g["a"])(regeneratorRuntime.mark((function t(){return regeneratorRuntime.wrap((function(t){while(1)switch(t.prev=t.next){case 0:console.log(e.$route.params.productID),fetch("http://localhost:8081/product/".concat(e.$route.params.productID),{mode:"cors",method:"GET"}).then((function(e){return e.body})).then((function(e){var t=e.getReader();return new ReadableStream({start:function(e){function n(){t.read().then((function(t){var r=t.done,o=t.value;if(r)return console.log("done",r),void e.close();e.enqueue(o),console.log(r,o),n()}))}n()}})})).then((function(e){return new Response(e,{headers:{"Content-Type":"text/html"}}).text()})).then((function(t){console.log(t),ce["verify"](e.token,"secret",(function(n,r){n?e.$router.push({name:"UsersLogin"}):(e.product=JSON.parse(t).product,e.useremail=r.useremail)}))}));case 2:case"end":return t.stop()}}),t)})))()},components:{Header:se,Footer:fe}};n("9ec2");xe.render=ke,xe.__scopeId="data-v-41ec35a7";var Re=xe,qe=Object(r["g"])("h1",{style:{"text-align":"center",color:"white"}},"Пользователь успешно создан!",-1);function Se(e,t,n,o,c,a){var s=Object(r["w"])("Header"),u=Object(r["w"])("Footer");return Object(r["p"])(),Object(r["d"])("div",null,[Object(r["g"])(s,{useremail:e.$route.query.useremail,auth:!0},null,8,["useremail"]),qe,Object(r["g"])(u)])}var Ce={name:"UserCreateSuccess",data:function(){return{useremail:""}},methods:{logoutUser:function(){window.localStorage.clear(),this.$router.push({name:"UsersLogin"})}},components:{Header:se,Footer:fe}};Ce.render=Se;var $e=Ce,Te={class:"navbar navbar-expand-lg navbar-light bg-light"},Ue={class:"container-fluid"},_e=Object(r["g"])("a",{class:"navbar-brand",href:"#"},"Market Town",-1),Ee=Object(r["g"])("button",{class:"navbar-toggler",type:"button","data-bs-toggle":"collapse","data-bs-target":"#navbarNav","aria-controls":"navbarNav","aria-expanded":"false","aria-label":"Toggle navigation"},[Object(r["g"])("span",{class:"navbar-toggler-icon"})],-1),Ie={class:"collapse navbar-collapse",id:"navbarNav"},He={class:"navbar-nav"},Be={class:"nav-item"},Ne=Object(r["f"])(" Вход "),Pe={class:"nav-item"},Fe=Object(r["f"])(" Регистрация "),Ae={key:0},Le={class:"card-header"},Je={href:"#"},Ge={class:"card-body"},De={class:"card-title"},Ve=Object(r["g"])("p",{class:"card-text"},"With supporting text below as a natural lead-in to additional content.",-1),Me={key:1};function Ke(e,t,n,o,c,a){var s=Object(r["w"])("router-link");return Object(r["p"])(),Object(r["d"])("div",null,[Object(r["g"])("nav",Te,[Object(r["g"])("div",Ue,[_e,Ee,Object(r["g"])("div",Ie,[Object(r["g"])("ul",He,[Object(r["g"])("div",null,[Object(r["g"])("li",Be,[Object(r["g"])(s,{class:"nav-item",to:{name:"UsersLogin"}},{default:Object(r["C"])((function(){return[Ne]})),_:1})]),Object(r["g"])("li",Pe,[Object(r["g"])(s,{class:"nav-item",to:{name:"UsersRegistry"}},{default:Object(r["C"])((function(){return[Fe]})),_:1})])])])])])]),(Object(r["p"])(!0),Object(r["d"])(r["a"],null,Object(r["v"])(c.allOrders,(function(e){return Object(r["p"])(),Object(r["d"])("div",{key:e._id,class:"card"},[c.allOrders.length>=1?(Object(r["p"])(),Object(r["d"])("div",Ae,[Object(r["g"])("h5",Le,[Object(r["g"])("a",Je,Object(r["y"])(e.ownername),1)]),Object(r["g"])("div",Ge,[Object(r["g"])("h5",De,Object(r["y"])(e.price),1),Ve])])):0==c.allOrders.length?(Object(r["p"])(),Object(r["d"])("div",Me," список заказов этого пользователя пуст ")):Object(r["e"])("",!0)])})),128))])}var ze={name:"OrdersList",data:function(){return{allOrders:[]}},mounted:function(){var e=this;return Object(g["a"])(regeneratorRuntime.mark((function t(){return regeneratorRuntime.wrap((function(t){while(1)switch(t.prev=t.next){case 0:fetch("http://localhost:8081/admin/orders?useremail".concat(e.$route.query.useremail),{mode:"cors",method:"GET"}).then((function(e){return e.body})).then((function(e){var t=e.getReader();return new ReadableStream({start:function(e){function n(){t.read().then((function(t){var r=t.done,o=t.value;if(r)return console.log("done",r),void e.close();e.enqueue(o),console.log(r,o),n()}))}n()}})})).then((function(e){return new Response(e,{headers:{"Content-Type":"text/html"}}).text()})).then((function(t){console.log(t),e.allOrders=JSON.parse(t)}));case 1:case"end":return t.stop()}}),t)})))()}};ze.render=Ke;var We=ze,Qe=Object(r["E"])("data-v-69ffe3f6");Object(r["s"])("data-v-69ffe3f6");var Xe={class:"customCardGroup"},Ye={key:0},Ze={class:"card-header"},et={class:"card-body"},tt={class:"customErros"},nt={key:1},rt=Object(r["f"])(" У вас нет ещё ни одного товара в корзине ");Object(r["q"])();var ot=Qe((function(e,t,n,o,c,a){var s=Object(r["w"])("Header"),u=Object(r["w"])("router-link"),l=Object(r["w"])("Footer");return Object(r["p"])(),Object(r["d"])(r["a"],null,[Object(r["g"])("div",null,[Object(r["g"])(s,{useremail:e.$route.query.useremail,auth:!0},null,8,["useremail"]),Object(r["g"])("div",Xe,[c.allProductsInBucketOfThisUser.length>0?(Object(r["p"])(),Object(r["d"])("div",Ye,[(Object(r["p"])(!0),Object(r["d"])(r["a"],null,Object(r["v"])(c.allProductsInBucketOfThisUser,(function(e){return Object(r["p"])(),Object(r["d"])("div",{class:"card",key:e.id},[Object(r["g"])("h5",Ze,[Object(r["f"])(Object(r["y"])(e.name)+" ",1),Object(r["g"])("span",{onClick:function(t){return a.deleteFromBucket(e.name,e.id)},style:{cursor:"pointer"},class:"material-icons"}," close ",8,["onClick"])]),Object(r["g"])("div",et,[Object(r["g"])("h5",null,Object(r["y"])(e.price)+"$",1),Object(r["g"])("button",{onClick:function(t){return a.deleteFromBucket(e.name,e.id)},class:"btn btn-danger"},"удалить из корзины",8,["onClick"])])])})),128)),Object(r["g"])("button",{style:{"font-size":"22px","min-width":"150px"},onClick:t[1]||(t[1]=function(e){return a.addOrder()}),class:"order form-control btn btn-success"}," Оформить заказ "+Object(r["y"])(c.priceForAllOrders)+"$ ",1),Object(r["g"])("p",tt,Object(r["y"])(c.errors),1)])):(Object(r["p"])(),Object(r["d"])("div",nt,[Object(r["g"])(u,{to:{name:"Home"},class:"form-control btn btn-danger"},{default:Qe((function(){return[rt]})),_:1})]))])]),Object(r["g"])(l)],64)})),ct=(n("d81d"),{name:"Bucket",data:function(){return{allProductsInBucketOfThisUser:{},priceForAllOrders:0,errors:"",token:window.localStorage.getItem("markettowntoken")}},mounted:function(){var e=this;return Object(g["a"])(regeneratorRuntime.mark((function t(){return regeneratorRuntime.wrap((function(t){while(1)switch(t.prev=t.next){case 0:console.log(e.$route.query.useremail),fetch("http://localhost:8081/users/bucket?useremail=".concat(e.$route.query.useremail),{mode:"cors",method:"GET"}).then((function(e){return e.body})).then((function(e){var t=e.getReader();return new ReadableStream({start:function(e){function n(){t.read().then((function(t){var r=t.done,o=t.value;if(r)return console.log("done",r),void e.close();e.enqueue(o),console.log(r,o),n()}))}n()}})})).then((function(e){return new Response(e,{headers:{"Content-Type":"text/html"}}).text()})).then((function(t){ce["verify"](e.token,"secret",(function(n,r){n?e.$router.push({name:"UsersLogin"}):(console.log(JSON.parse(t)),e.allProductsInBucketOfThisUser=JSON.parse(t).productsInBucket,e.allProductsInBucketOfThisUser.map((function(t){e.priceForAllOrders+=t.price})))}))}));case 2:case"end":return t.stop()}}),t)})))()},methods:{goToPage:function(e){e.includes("home")&&this.router.push({name:"Home"})},addOrder:function(){var e=this;fetch("http://localhost:8081/users/bucket/buy?useremail=".concat(this.$route.query.useremail),{mode:"cors",method:"GET"}).then((function(e){return e.body})).then((function(e){var t=e.getReader();return new ReadableStream({start:function(e){function n(){t.read().then((function(t){var r=t.done,o=t.value;if(r)return console.log("done",r),void e.close();e.enqueue(o),console.log(r,o),n()}))}n()}})})).then((function(e){return new Response(e,{headers:{"Content-Type":"text/html"}}).text()})).then((function(t){ce["verify"](e.token,"secret",(function(n,r){n?e.$router.push({name:"UsersLogin"}):JSON.parse(t).status.includes("OK")?e.$router.push({name:"Amount",query:{useremail:e.$route.query.useremail,amount:0}}):JSON.parse(t).status.includes("Error")&&(e.errors="У вас не хватает денег!!!",setTimeout((function(){e.errors=""}),5e3))}))}))},deleteFromBucket:function(e,t){var n=this;fetch("http://localhost:8081/users/bucket/delete?useremail=".concat(this.$route.query.useremail,"&productname=").concat(e,"&productid=").concat(t),{mode:"cors",method:"GET"}).then((function(e){return e.body})).then((function(e){var t=e.getReader();return new ReadableStream({start:function(e){function n(){t.read().then((function(t){var r=t.done,o=t.value;if(r)return console.log("done",r),void e.close();e.enqueue(o),console.log(r,o),n()}))}n()}})})).then((function(e){return new Response(e,{headers:{"Content-Type":"text/html"}}).text()})).then((function(e){ce["verify"](n.token,"secret",(function(e,t){e?n.$router.push({name:"UsersLogin"}):n.$router.push({name:"Home"})}))}))}},components:{Header:se,Footer:fe}});n("1036");ct.render=ot,ct.__scopeId="data-v-69ffe3f6";var at=ct,st=Object(r["E"])("data-v-4be16d66");Object(r["s"])("data-v-4be16d66");var ut={class:"customCardGroup"},lt=Object(r["g"])("img",{class:"mb-4",src:"https://cdn4.iconfinder.com/data/icons/logos-brands-5/24/vue-dot-js-256.png",alt:"",width:"72",height:"72"},null,-1),it=Object(r["g"])("h1",{class:"headerform h3 mb-3 font-weight-normal"},"Войдите",-1),dt=Object(r["g"])("div",{class:"checkbox mb-3"},null,-1),bt={class:"customErros"};Object(r["q"])();var mt=st((function(e,t,n,o,c,a){var s=Object(r["w"])("Header"),u=Object(r["w"])("Footer");return Object(r["p"])(),Object(r["d"])(r["a"],null,[Object(r["g"])("div",null,[Object(r["g"])(s,{auth:!1,touser:""}),Object(r["g"])("div",ut,[lt,it,Object(r["D"])(Object(r["g"])("input",{"onUpdate:modelValue":t[1]||(t[1]=function(e){return c.useremail=e}),type:"email",id:"inputEmail",class:"useremail form-control",placeholder:"Email address",required:"",autofocus:""},null,512),[[r["A"],c.useremail]]),Object(r["D"])(Object(r["g"])("input",{"onUpdate:modelValue":t[2]||(t[2]=function(e){return c.userpassword=e}),type:"password",id:"inputPassword",class:"userpassword form-control",placeholder:"Password",required:""},null,512),[[r["A"],c.userpassword]]),dt,Object(r["g"])("button",{onClick:t[3]||(t[3]=function(){return a.loginUser&&a.loginUser.apply(a,arguments)}),style:{"min-width":"85px"},class:"btn btn-lg btn-danger btn-block loginBtn"},"Войти"),Object(r["g"])("div",bt,Object(r["y"])(c.errors),1)])]),Object(r["g"])(u)],64)})),ft={name:"UsersLogin",data:function(){return{useremail:"",userpassword:"",errors:"",token:""}},methods:{loginUser:function(){var e=this;return Object(g["a"])(regeneratorRuntime.mark((function t(){return regeneratorRuntime.wrap((function(t){while(1)switch(t.prev=t.next){case 0:return t.next=2,fetch("http://localhost:8081/users/check?useremail=".concat(e.useremail,"&userpassword=").concat(e.userpassword),{mode:"cors",method:"GET"}).then((function(e){return e.body})).then((function(e){var t=e.getReader();return new ReadableStream({start:function(e){function n(){t.read().then((function(t){var r=t.done,o=t.value;if(r)return console.log("done",r),void e.close();e.enqueue(o),console.log(r,o),n()}))}n()}})})).then((function(e){return new Response(e,{headers:{"Content-Type":"text/html"}}).text()})).then((function(t){console.log(JSON.parse(t)),JSON.parse(t).status.includes("OK")?(window.localStorage.setItem("auth","true"),e.token=ce["sign"]({useremail:e.useremail},"secret",{expiresIn:"5m"}),window.localStorage.setItem("markettowntoken",e.token),e.$router.push({name:"Home"})):JSON.parse(t).status.includes("Error")&&(e.errors="Такого пользователя не существует!!!")}));case 2:case"end":return t.stop()}}),t)})))()}},components:{Header:se,Footer:fe}};n("e528");ft.render=mt,ft.__scopeId="data-v-4be16d66";var gt=ft,pt=Object(r["E"])("data-v-7138b2d8");Object(r["s"])("data-v-7138b2d8");var Ot={class:"customCardGroup"},ht=Object(r["g"])("img",{class:"mb-4",src:"https://cdn4.iconfinder.com/data/icons/logos-brands-5/24/vue-dot-js-256.png",alt:"",width:"72",height:"72"},null,-1),jt=Object(r["g"])("h1",{class:"h3 mb-3 font-weight-normal headerform"},"Зарегистрируйтесь",-1),vt=Object(r["g"])("div",{class:"checkbox mb-3"},null,-1),yt={class:"customErros"};Object(r["q"])();var wt=pt((function(e,t,n,o,c,a){var s=Object(r["w"])("Header"),u=Object(r["w"])("Footer");return Object(r["p"])(),Object(r["d"])(r["a"],null,[Object(r["g"])("div",null,[Object(r["g"])(s),Object(r["g"])("div",Ot,[ht,jt,Object(r["D"])(Object(r["g"])("input",{"onUpdate:modelValue":t[1]||(t[1]=function(e){return c.useremail=e}),type:"email",id:"",class:"useremail form-control",placeholder:"Email address",required:"",autofocus:""},null,512),[[r["A"],c.useremail]]),Object(r["D"])(Object(r["g"])("input",{"onUpdate:modelValue":t[2]||(t[2]=function(e){return c.userpassword=e}),type:"password",id:"",class:"userpassword form-control",placeholder:"Password",required:""},null,512),[[r["A"],c.userpassword]]),Object(r["D"])(Object(r["g"])("input",{"onUpdate:modelValue":t[3]||(t[3]=function(e){return c.userage=e}),type:"text",id:"",class:"userage  form-control",placeholder:"Age",required:"",autofocus:""},null,512),[[r["A"],c.userage]]),Object(r["D"])(Object(r["g"])("input",{"onUpdate:modelValue":t[4]||(t[4]=function(e){return c.username=e}),type:"text",id:"",class:"username form-control",placeholder:"Name",required:"",autofocus:""},null,512),[[r["A"],c.username]]),vt,Object(r["g"])("button",{style:{"font-size":"16px","min-width":"175px"},onClick:t[5]||(t[5]=function(){return a.registerNewUser&&a.registerNewUser.apply(a,arguments)}),class:"btn btn-lg btn-danger btn-block registerBtn"},"Зарегистрироваться"),Object(r["g"])("div",yt,Object(r["y"])(c.errors),1)])]),Object(r["g"])(u)],64)})),kt={name:"UsersRegistry",data:function(){return{useremail:"",userpassword:"",userage:0,username:"",errors:""}},methods:{registerNewUser:function(){var e=this;fetch("http://localhost:8081/users/usercreatesuccess?useremail=".concat(this.useremail,"&userpassword=").concat(this.userpassword,"&username=").concat(this.username,"&userage=").concat(this.userage),{mode:"cors",method:"GET"}).then((function(e){return e.body})).then((function(e){var t=e.getReader();return new ReadableStream({start:function(e){function n(){t.read().then((function(t){var r=t.done,o=t.value;if(r)return console.log("done",r),void e.close();e.enqueue(o),console.log(r,o),n()}))}n()}})})).then((function(e){return new Response(e,{headers:{"Content-Type":"text/html"}}).text()})).then((function(t){console.log(t),t.includes("created")?(window.localStorage.setItem("auth","true"),window.localStorage.setItem("useremail",e.useremail),e.$router.push({name:"UsersLogin",query:{useremail:e.useremail}})):t.includes("rollback")&&(e.errors="Такой пользователь уже существует!!!")}))}},components:{Header:se,Footer:fe}};n("655a");kt.render=wt,kt.__scopeId="data-v-7138b2d8";var xt=kt,Rt=Object(r["E"])("data-v-61c7aefe");Object(r["s"])("data-v-61c7aefe");var qt={class:"main"},St={class:"form-control"},Ct={style:{"text-align":"center"}},$t=Object(r["f"])("У вас сейчас на счёте ");Object(r["q"])();var Tt=Rt((function(e,t,n,o,c,a){var s=Object(r["w"])("Header"),u=Object(r["w"])("Footer");return Object(r["p"])(),Object(r["d"])(r["a"],null,[Object(r["g"])(s,{useremail:e.useremail,auth:!0},null,8,["useremail"]),Object(r["g"])("div",qt,[Object(r["g"])("div",St,[Object(r["g"])("p",Ct,[$t,Object(r["g"])("b",null,Object(r["y"])(c.moneys)+"$",1)]),Object(r["D"])(Object(r["g"])("input",{class:"myamount","onUpdate:modelValue":t[1]||(t[1]=function(e){return c.myamount=e}),type:"text"},null,512),[[r["A"],c.myamount]]),Object(r["g"])("a",{onClick:t[2]||(t[2]=function(){return a.addAmount&&a.addAmount.apply(a,arguments)}),class:"form-control btn btn-danger"}," Пополнить счёт ")]),Object(r["g"])(u)])],64)})),Ut={name:"Amount",data:function(){return{myamount:0,moneys:0,token:window.localStorage.getItem("markettowntoken")}},mounted:function(){var e=this;fetch("http://localhost:8081/users/amount?useremail=".concat(this.$route.query.useremail,"&amount=0"),{mode:"cors",method:"GET"}).then((function(e){return e.body})).then((function(e){var t=e.getReader();return new ReadableStream({start:function(e){function n(){t.read().then((function(t){var r=t.done,o=t.value;if(r)return console.log("done",r),void e.close();e.enqueue(o),console.log(r,o),n()}))}n()}})})).then((function(e){return new Response(e,{headers:{"Content-Type":"text/html"}}).text()})).then((function(t){ce["verify"](e.token,"secret",(function(n,r){n?e.$router.push({name:"UsersLogin"}):JSON.parse(t).status.includes("OK")&&(e.moneys=JSON.parse(t).moneys,e.useremail=r.useremail)}))}))},methods:{addAmount:function(){var e=this;return Object(g["a"])(regeneratorRuntime.mark((function t(){return regeneratorRuntime.wrap((function(t){while(1)switch(t.prev=t.next){case 0:return t.next=2,fetch("http://localhost:8081/users/amount?useremail=".concat(e.useremail,"&amount=").concat(e.myamount),{mode:"cors",method:"GET"}).then((function(e){return e.body})).then((function(e){var t=e.getReader();return new ReadableStream({start:function(e){function n(){t.read().then((function(t){var r=t.done,o=t.value;if(r)return console.log("done",r),void e.close();e.enqueue(o),console.log(r,o),n()}))}n()}})})).then((function(e){return new Response(e,{headers:{"Content-Type":"text/html"}}).text()})).then((function(t){console.log(JSON.parse(t)),JSON.parse(t).status.includes("OK")&&e.$router.push({name:"Home"})}));case 2:case"end":return t.stop()}}),t)})))()}},components:{Header:se,Footer:fe}};n("43dd");Ut.render=Tt,Ut.__scopeId="data-v-61c7aefe";var _t=Ut,Et=[{path:"/",name:"Home",component:pe},{path:"/products/:productID",name:"product",component:Re},{path:"/user/usercreatesuccess",name:"UserCreateSuccess",component:$e},{path:"/admin/orders",name:"OrdersList",component:We},{path:"/user/bucket",name:"Bucket",component:at},{path:"/users/login",name:"UsersLogin",component:gt},{path:"/users/register",name:"UsersRegistry",component:xt},{path:"/user/amount",name:"Amount",component:_t}],It=Object(s["a"])({history:Object(s["b"])("/"),routes:Et}),Ht=It,Bt=n("5502"),Nt=Object(Bt["a"])({state:{},mutations:{},actions:{},modules:{}});Object(r["c"])(a).use(Nt).use(Ht).mount("#app")},6:function(e,t){},"655a":function(e,t,n){"use strict";n("916a")},7:function(e,t){},"7c8a":function(e,t,n){},8:function(e,t){},"87bf":function(e,t,n){},9:function(e,t){},"916a":function(e,t,n){},"9ec2":function(e,t,n){"use strict";n("4a71")},a2aa:function(e,t,n){"use strict";n("13fa")},a845:function(e,t,n){},c715:function(e,t,n){},e528:function(e,t,n){"use strict";n("7c8a")},ec88:function(e,t,n){},f614:function(e,t,n){"use strict";n("ec88")}});
//# sourceMappingURL=app.2ca2bf35.js.map