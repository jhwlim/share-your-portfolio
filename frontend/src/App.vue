<template>
  <div id="app">
    <HeaderNav v-if="hasHeaderNav"></HeaderNav>
    <router-view></router-view>
  </div>
</template>

<script>
import HeaderNav from '@/components/static/HeaderNav.vue';
export default {
  name: 'App',
  data: function() {
    return {
      hasHeaderNav: this.$route.meta.hasHeaderNav === undefined ? true : this.$route.meta.hasHeaderNav,
    };
  },
  components: {
    HeaderNav,
  },
}
</script>

<style scoped>
@import './assets/css/static/app.css';
</style>