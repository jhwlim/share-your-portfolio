<template>
    <v-layout class="justify-center">
        <v-sheet
            width="1000"
            elevation="1"
            class="pa-2"
        >

            <v-list 
                subheader
                dense
            >
                <v-subheader class="text-h6 px-4 font-weight-bold">All Posts</v-subheader>

                <v-list-item
                    v-for="post in posts"
                    :key="post.id"
                >
                    <v-list-item-avatar
                        tile
                        size="50%"
                    >
                        <v-img
                            width="100%"
                            :src="require('@/assets/images/test/post.jpg')"
                        ></v-img>
                    </v-list-item-avatar>
                    
                    <v-list-item-content 
                        class="align-start align-self-start"
                    >
                        <v-card flat>
                            <v-container>
                                <v-avatar size="36px">
                                    <v-icon>
                                        mdi-account-circle
                                    </v-icon>
                                </v-avatar>
                            </v-container>

                            <v-card-title>
                                Title
                            </v-card-title>


                            <v-card-text>
                                Lorem ipsum, dolor sit amet consectetur adipisicing elit. Quidem esse illum dolor tempore error commodi sequi maxime neque, officia eveniet recusandae facere molestias illo quibusdam cum aliquam voluptas necessitatibus? Aliquam.
                            </v-card-text>

                            <v-card-actions>
                                <div class="mr-2">
                                    <span>{{ post.viewCount }}</span> views
                                </div>
                                <div>
                                    <span>{{ post.commentCount }}</span> comments
                                </div>
                                <v-spacer></v-spacer>
                                <div>
                                    <span>{{ post.likeCount }}</span>
                                    <v-icon color="red" class="mx-2">
                                        mdi-heart
                                    </v-icon>
                                </div>
                            </v-card-actions>
                        </v-card>
                        
                    </v-list-item-content>

                </v-list-item>
            </v-list>
        </v-sheet>
    </v-layout>
</template>

<script>
export default {
    name: 'MainView',
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
                    image: ''
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
                    image: '',
                },
            ], 
        }
    },
}
</script>

<style>

</style>