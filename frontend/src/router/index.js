import Vue from 'vue';
import VueRouter from 'vue-router';
import MainView from '@/views/MainView.vue';
import TestView from '@/views/TestView.vue';

Vue.use(VueRouter);

const router = new VueRouter({
    mode: 'history',
    routes: [
        { 
            path: '/', 
            name: 'main', 
            component: MainView,
        },
        { 
            path: '/test', 
            name: 'test', 
            component: TestView,
            meta: {
                hasHeaderNav: false,
            } 
        },
    ]
});

export default router;