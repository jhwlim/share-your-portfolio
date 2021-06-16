/* eslint-disable */
import Vue from 'vue';
import VueRouter from 'vue-router';
import MainView from '@/views/MainView.vue';
import LoginView from '@/views/LoginView.vue';
import TestView from '@/views/TestView.vue';
import store from '@/store';

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
            path: '/login',
            name: 'login',
            component: LoginView,
            meta: {
                hasHeaderNav: false,
            },
            beforeEnter: (to, from, next) => {
                store.getters.isLogined ? next('/') : next();
            },
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