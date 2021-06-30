<template>
    <div class="post-list">        
        <post-description v-for="(post, index) in posts" :key="index" :post="post"></post-description>
    </div>
</template>

<script>
import PostDescription from './PostDescription.vue';

export default {
    components: {
        PostDescription,
    },
    data: function() {
        return {
            posts: [
                {
                    id: 1,
                    imagePath : '',
                    writer: 'test01',
                    writerId: 1,
                    writeDate: 'Dec 2, 2020',
                    title: 'Low Maintenance Plants You Can Grow',
                    content: 'Lorem ipsum, dolor sit amet consectetur adipisicing elit. Doloribus, odit?',
                    viewCount: 11,
                    commentCount: 5,
                    likeCount: 3,
                    isLiked: true,
                },
                {
                    id: 3,
                    imagePath : '',
                    writer: 'test02',
                    writerId: 2,
                    writeDate: 'Dec 1, 2019',
                    title: 'Healthy, Herby Meals',
                    content: 'Lorem ipsum, dolor sit amet consectetur adipisicing elit. Doloribus, odit?',
                    viewCount: 9,
                    commentCount: 8,
                    likeCount: 10,
                    isLiked: false,
                },
            ],
        };
    },
}
</script>

<style scoped>
</style>