/* eslint-disable */
import Vue from 'vue';
import App from '@/App.vue';
import store from '@/store';
import router from '@/router';
import axios from '@/plugins/axios.js';

import '@/assets/css/static/reset.css';

Vue.config.productionTip = false

const init = async () => {
  await store.dispatch('init');

  new Vue({
    store,
    router,
    created: async function() {
      this.$mount('#app');
    },
    render: h => h(App),
  });
};

init();
