import Vue from 'vue';
import App from '@/App.vue';
import router from '@/router';
import store from '@/store';
import { mapMutations } from 'vuex';

import '@/assets/css/static/reset.css';

Vue.config.productionTip = false

new Vue({
  methods: {
    ...mapMutations(['user', 'initUserInfo']),
  },
  router,
  store,
  created: function() {
    this.initUserInfo();
  },
  render: h => h(App),
}).$mount('#app')
