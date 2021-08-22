import MainView from '@/views/MainView.vue';
import LoginView from '@/views/LoginView.vue';
import SignupView from '@/views/SignupView.vue';

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
    }
]

export default routes;