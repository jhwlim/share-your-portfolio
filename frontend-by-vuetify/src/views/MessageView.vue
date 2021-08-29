<template>
    <v-layout class="justify-center align-center px-1">
        <v-sheet width="100%" max-width="1000px" class="rounded-lg">
            <v-row height="100%">
                <v-col cols="auto">
                    <v-list two-line color="grey lighten-3" class="rounded-l-lg pt-4" height="600" width="300">
                        <template v-for="(user, index) in users">
                            <v-list-item :key="user.id" @click="selectUser(user)">
                                <v-list-item-avatar>
                                    <user-image :id="user.id"></user-image>
                                </v-list-item-avatar>
                                
                                <v-list-item-content>
                                    <v-list-item-title class="d-flex justify-space-between">
                                        <span class="font-weight-bold">{{ user.name }}</span>
                                        <span class="font-weight-light grey--text">{{ user.latestSendTime }}</span>
                                    </v-list-item-title>
                                    <v-list-item-subtitle v-text="user.latestMessage"></v-list-item-subtitle>
                                </v-list-item-content>

                            </v-list-item>

                            <v-divider v-if="index < users.length-1" :key="index"></v-divider>
                        </template>
                    </v-list>

                </v-col>
                <v-col>
                    <v-card v-if="isSelected" flat class="rounded-r-lg pt-4">
                        <v-card-title>
                            <user-image class="mr-2"></user-image>
                            <span>{{ selectedUser.name }}</span>
                        </v-card-title>

                        <v-divider class="mr-5"></v-divider>

                        <v-card-text>
                            <v-list class="overflow-y-auto" height="400">

                            </v-list>
                        </v-card-text>

                        <v-divider class="mr-5"></v-divider>

                        <v-card-actions class="py-0 pr-6 align-end">
                            <v-text-field></v-text-field>
                            <v-btn elevation="0" color="primary" class="ml-4 mr-1 mb-5 px-6">Send</v-btn>
                        </v-card-actions>
                    </v-card>
                    <div v-else class="py-4 text-subtitle-1">대화 상대를 선택하세요</div>
                </v-col>
                
            </v-row>
        </v-sheet>
    </v-layout>
</template>

<script>
import UserImage from '@/components/UserImage.vue';

export default {
    name: 'MessageView',
    components: {
        UserImage,
    },
    data: function() {
        return {
            users: [
                {
                    id: 3,
                    name: '테스터03',
                    latestMessage: 'Hi',
                    latestSendTime: '10:34 AM'
                },
                {
                    id: 2,
                    name: '테스터02',
                    latestMessage: 'Hello!',
                    latestSendTime: '11:30 PM'    
                }
            ],
            selectedUser: null,
        }
    },
    computed: {
        isSelected() {
            return !!this.selectedUser;
        }
    },
    methods: {
        selectUser(user) {
            this.selectedUser = user;
        }
    }
}
</script>\