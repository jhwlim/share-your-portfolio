<template>
  <div id="app">
    face
    <span class="material-icons md-18">face</span>
    <button @click="testApi()">API 테스트</button>
  </div>
</template>

<script>
import '@/assets/css/static/reset.css';
import '@/assets/css/static/app.css'
import TestApi from '@/api/TestApi.js'

export default {
  name: 'App',
  methods: {
    testApi() {
      TestApi.test()
        .then((response) => {
          console.log(response);
        })
        .catch((error) => {
          console.log(error);
        });
      TestApi.test1();
    },
  },
}
</script>