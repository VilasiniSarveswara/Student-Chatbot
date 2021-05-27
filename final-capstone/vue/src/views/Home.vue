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

    //<chat />
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
        <div>
          <p v-for="greeting in greetings" v-bind:key="greeting.index">
            {{ greeting }}
          </p>
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
          <button v-on:click="sendMessage">Send</button>
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
import AuthService from "../services/AuthService.js";

export default {
  name: "home",
  components: Chat,

  data() {
    return {
      topic: "",
      message: "",
      messages: [],
      toBeDecidedtopic: "",
      showChatWindow: false,
      showStartChatBtn: true,
      pathwayOptions: [
        "Sample Technical Questions",
        "Sample Behavioral Questions",
        "Cover Letter Help",
        "Interview Attire",
      ],
      greetings: [
        "Hi, how can I help you today?",
        "Please choose from the following options:",
        "1. Pathway ",
        "2. Curriculum",
        "3. Find Open Positions",
      ],
    };
  },
  methods: {
    startChat() {
      this.showChatWindow = true;
      this.showStartChatBtn = false;
    },

    topicToBeDecided(message) {
      var msg = message.toLowerCase();
      if (msg.includes("pathway") || msg.includes("pathways")) {
        this.topic = "pathway";
        this.messages.push({
          text: "Sure, what are you looking for in " + this.topic + "?",
          author: "bot",
        });

        this.messages.push({
          text: "Here are some options to choose from: ",
          author: "bot",
        });

        this.pathwayOptions.forEach((option) => {
          this.messages.push({ text: option, author: "bot" });
        });
      } else if (
        msg.includes("curriculum") ||
        msg.includes("class") ||
        msg.includes("homework")
      ) {
        this.topic = "curriculum";
      } else if (
        msg.includes("position") ||
        msg.includes("job") ||
        msg.includes("opportunities")
      ) {
        this.topic = "job";
      } else if (msg.includes("technical")) {
        this.topic = "technical";
        AuthService.getPathwayDetails(this.topic).then((response) => {
          if (response.status == 200) {
            this.messages.push({
              text:
                "Here's something I think will be useful: " +
                response.data.responseText,
              author: "bot",
            });
          }
        });
      } else if (msg.includes("behavioral")) {
        this.topic = "behavioral";
        AuthService.getPathwayDetails(this.topic);
      } else if (msg.includes("cover") || msg.includes("letter")) {
        this.topic = "cover";
      } else if (
        msg.includes("attire") ||
        msg.includes("dress") ||
        msg.includes("business wear") ||
        msg.includes("cloth")
      ) {
        this.topic = "business wear";
      }
    },

    sendMessage() {
      this.messages.push({
        text: this.message,
        author: "client",
      });
      this.topicToBeDecided(this.message);
      this.message = "";
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

button {
  position: fixed;
  bottom: 10px;
  right: 10px;
}
.chat-container {
  position: fixed;
  width: 1250px;
  height: 700px;
  border: 1px solid black;
  bottom: 10px;
  right: 10px;
  font-size: 20px;
  font-weight: bold;
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

