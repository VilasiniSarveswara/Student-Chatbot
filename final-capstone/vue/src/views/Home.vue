<template>
  <div class="home">
    <div id="nav">
      <router-link v-bind:to="{ name: 'home' }">Home</router-link>
      <router-link v-bind:to="{ name: 'my-account' }">My Account</router-link>
      <router-link
        v-bind:to="{ name: 'logout' }"
        v-if="$store.state.token != ''"
        >Logout</router-link
      >
    </div>

    <div id="heading-wrapper">
      <h2 id="welcome-message">
        Welcome, {{ this.$store.state.user_details.firstName }}!
      </h2>
      <h6 v-if="this.$store.state.user_details.student">Student</h6>
      <h6 v-else>Alumni</h6>
    </div>

    <chat />
    <button
      id="startchat"
      v-if="this.showStartChatBtn"
      class="chat-assistant-button"
      v-on:click="startChat"
    >
      Start Chat
    </button>
    <div class="chat" v-else>
      <div class="chat-container" ref="chatbox">
        <div v-for="greeting in greetings" v-bind:key="greeting">
          {{ greeting }}
        </div>
        <ul class="chat-box-list">
          <li
            class="message"
            v-for="(message, index) in messages"
            :key="index"
            :class="message.author"
          >
            <p>
              <span> {{ message.text }} </span>
            </p>
          </li>
        </ul>
        <div class="chat-inputs">
          <input
            class="chatinputbox"
            type="text"
            v-model="message"
            @keyup.enter="sendMessage"
          />
          <button @click="sendMessage">Send</button>
        </div>
      </div>
    </div>

    <chat />
  </div>
</template>
 <!-- in Styling, float left and float right will have the messages displaying on either side, and using the dynamic class 
  messages can be put into different colors. with the sendMessage function we need to be able to send a request to the back end
  and we need to be able to get the response to put into our messages from the back end's answer.
  
  setting an overflow: scroll will keep the chatbox from distorting when there are more messages than the window can contain-->

<script>
import Chat from "../components/Chat.vue";

export default {
  name: "home",
  components: Chat,
  showChatWindow: false,
  showStartChatBtn: true,
  data() {
    return {
      message: "",
      messages: [],
    };
  },
  methods: {
    startChat() {
      this.showChatWindow = true;
      this.showStartChatBtn = false;
      this.message = "Hi, how can I help you today?";
    },
    sendMessage() {
      this.message.push({
        text: this.message,
        author: "client",
      });

      this.message = ""

        //get request
        .then((response) => {
          this.messages.push({
            text: response.data.output,
            author: "server",
          });

          this.nextTick(() => {
            this.$refs.chatbox.scrollTop = this.$refs.chatbox.scrollHeight;
          });
        });
    },
  },
};
</script>

<style scoped>
h6 {
  font-size: 32px;
  color: #caf0f8;
  margin-top: 1%;
  margin-left: 3%;
  font-family: "Oswald", sans-serif;
  letter-spacing: 2px;
}
h2 {
  font-size: 60px;
  font-family: "Open Sans", sans-serif;
  margin-bottom: 0%;
  margin-top: 3.5%;
  margin-left: 3%;
  letter-spacing: 3px;
}

#welcome-message {
  text-transform: capitalize;
}
form {
  margin-left: 3.5%;
  margin-top: 3%;
}

input {
  margin-left: 0.5%;
  margin-top: 2%;
}
label {
  font-size: 22px;
  color: #caf0f8;
  font-family: "Oswald", sans-serif;
  margin-top: 1%;
}
.startchat {
  visibility: visible;
}

.startchat {
  position: fixed;
  bottom: 10px;
  right: 10px;
}
.chat-inputs {
  position: fixed;
  width: 1250px;
  height: 700px;
  border: 1px solid black;
  bottom: 10px;
  right: 10px;
}
.chatinputbox {
  position: fixed;
  right: 10px;
  bottom: 10px;
  width: 1245px;
  height: 80px;
  font-size: 20px;
}
</style>

