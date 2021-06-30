<template>
    <div class="container">
        <post-header></post-header>
        <post-list></post-list>        
    </div>
</template>

<script>
import PostHeader from '@/components/post/PostHeader.vue';
import PostList from '@/components/post/PostList.vue';

export default {
    components: {
        PostHeader,
        PostList,
    },
}
</script>

<style scoped>
.container {
    margin: 0 auto;
    max-width: 950px;
}
</style>