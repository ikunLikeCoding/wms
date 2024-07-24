

import { createApp } from 'vue'
import App from './App.vue'
import router from './common/router'


import ElementPlus from 'element-plus'
import 'element-plus/dist/index.css'
import { get, put, del, tip } from "@/common";


const app = createApp(App)
app.use(ElementPlus)
app.use(router)
app.directive('permission', (el, binding)=>{

    if(!binding.value){
        return;
    }
    get("/permission/check",{
        permission:binding.value
    }).then((res)=>{
        if(res.data === true){
            console.log("权限通过")
            return;
        }else {
            el.style.display = 'none';
        }
    })



})
app.mount('#app')
