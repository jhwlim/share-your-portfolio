import MainView from '@/views/MainView.vue';
import LoginView from '@/views/LoginView.vue';
import SignupView from '@/views/SignupView.vue';
import AccountView from '@/views/AccountView.vue';
import MessageView from '@/views/MessageView.vue';

const routes = [
    {
        path: '/',
        name: 'main',
        component: MainView,
    },
    {
        path: '/login',
        name: 'login',
        component: LoginView,
    },
    {
        path: '/signup',
        name: 'signup',
        component: SignupView,
    },
    {
        path: '/account',
        name: 'account',
        component: AccountView, 
    },
    {
        path: '/message',
        name: 'message',
        component: MessageView,
    }
]

export default routes;