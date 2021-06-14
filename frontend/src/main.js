/* eslint-disable */
import Vue from 'vue';
import App from '@/App.vue';
import router from '@/router';
import store from '@/store';
import { mapActions } from 'vuex';
import axios from '@/plugins/axios.js';

import '@/assets/css/static/reset.css';

Vue.config.productionTip = false

new Vue({
  methods: {
    ...mapActions(['user', 'init']),
  },
  router,
  store,
  created: function() {
    this.init();
    this.$mount('#app');
  },
  render: h => h(App),
});
