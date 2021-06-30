<template>
    <div class="container post">
        <post-description-header 
            :id="post.writerId"
            :username="post.writer"
            :date="post.writeDate"></post-description-header>
        <h3 class="post__title post__title--margin--large">{{ post.title }}</h3>
        <div class="post__image">
            <img :src="post.images[currentImageIndex]" alt="">
        </div>
        <div class="post__all-images">
            <div v-for="(image, index) in post.images" :key="index" 
                class="post__all-images__item"
                :class="{ 'post__all-images__item--select': index === currentImageIndex }"
                @click="setCurrentImageIndex(index)">
                <img :src="image" alt="">
            </div>
        </div>
        <div class="post__content post__content--large">
            {{ post.content }}
            Lorem ipsum dolor, sit amet consectetur adipisicing elit. Recusandae corrupti eum vitae suscipit est qui nulla aperiam non pariatur quis adipisci consequuntur totam rem voluptatum architecto voluptatibus obcaecati, fuga natus facilis assumenda. Facere hic impedit omnis. Asperiores architecto voluptate, molestias iste distinctio voluptatibus omnis quas nulla sint, cupiditate, repellat in?
        </div>
        <post-description-footer
            :viewCount="post.viewCount"
            :commentCount="post.commentCount"
            :likeCount="post.likeCount"
            :isLiked="post.isLiked"
            ></post-description-footer>
        <div class="post-comment">
            <post-comment-input></post-comment-input>
            <post-comment-list
                :comments="comments"></post-comment-list>
        </div>
    </div>
</template>

<script>
import PostDescriptionHeader from '@/components/post/PostDescriptionHeader.vue';
import PostDescriptionFooter from '@/components/post/PostDescriptionFooter.vue';
import PostCommentInput from '@/components/post/PostCommentInput.vue';
import PostCommentList from '@/components/post/PostCommentList.vue';

export default {
    components: {
        PostDescriptionHeader,
        PostDescriptionFooter,
        PostCommentInput,
        PostCommentList,
    },
    data: function() {
        return {
            id: null,
            currentImageIndex: 0,
            post: {
                id: 1,
                writer: 'test01',
                writerId: 1,
                writeDate: 'Dec 2, 2020',
                title: 'Low Maintenance Plants You Can Grow',
                content: 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Dolore, nihil delectus quia, perspiciatis quidem animi aspernatur architecto, facere suscipit unde neque adipisci! Ut, ducimus harum laborum non dolorum labore omnis.',
                viewCount: 11,
                commentCount: 5,
                likeCount: 3,
                isLiked: true,
                images: [
                    'https://cdn.pixabay.com/photo/2021/06/01/06/24/old-town-6300696__340.jpg',
                    'https://cdn.pixabay.com/photo/2021/04/29/11/40/big-ben-6216420__340.jpg',
                    'https://cdn.pixabay.com/photo/2021/03/30/01/11/fife-6135609__340.jpg',
                ],
            },
            comments: [
                {
                    id: 10,
                    writer: 'test02',
                    writerId: 2,
                    writeDate: 'Dec 3, 2020',
                    content: 'Good!',
                },
                {
                    id: 17,
                    writer: 'test01',
                    writerId: 1,
                    writeDate: 'Dec 3, 2020',
                    content: '👍👍👍',
                }
            ],
        };
    },
    watch: {
        '$route': 'fetchData',    
    },
    methods: {
        fetchData() {
            this.id = this.$route.params.id;
        },
        setCurrentImageIndex(index) {
            this.currentImageIndex = index;
        }
    },
    created: function() {
        console.log(this.currentImageIndex);
        this.fetchData();
    },
}
</script>

<style scoped>
.container {
    margin: 60px auto;
    max-width: 950px;
    border: 1px solid lightgray;
    padding: 50px 80px;
}
.post__title--margin--large {
    margin: 30px 0;
    font-size: 36px;
}
.post__image {
    width: 100%;
}
.post__image img {
    width: 100%;
}
.post__all-images {
    margin: 10px 0;
    padding: 4px;
}
.post__all-images__item {
    display: inline-block;
    height: 100px;
    margin-right: 10px;
    border: 2px solid transparent;
}
.post__all-images__item img {
    height: 100%;
    object-fit: contain;
}
.post__all-images__item--select {
    border-color: red;
}
.post__content--large {
    font-size: 20px;
    line-height: 36px;
    border-bottom: 1.5px #b6b6b6 solid;
    padding-bottom: 60px;
}
.post-comment {
    margin: 30px 0;
}
</style>