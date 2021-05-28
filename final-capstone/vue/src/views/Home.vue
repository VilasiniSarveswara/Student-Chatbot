<template>
  <div class="home">
    <div class="head-wrapper">
      <div class="logo">
        <img
          src="../Images/robot-image.png"
          alt="robot-image"
          width="90px"
          height="95px"
        />
        <h2>HALPER</h2>
      </div>
      <div id="nav">
        <router-link v-bind:to="{ name: 'home' }">Home</router-link>
        <router-link v-bind:to="{ name: 'my-account' }">My Account</router-link>
        <router-link
          v-bind:to="{ name: 'logout' }"
          v-if="$store.state.token != ''"
          >Logout</router-link
        >
      </div>
    </div>

    <div class="body-wrapper">
      <h2 id="welcome-message">
        Welcome, {{ this.$store.state.user_details.firstName }}!
      </h2>
      <h6 v-if="this.$store.state.user_details.student">Student</h6>
      <h6 v-else>Alumni</h6>

      <button
        v-if="this.showStartChatBtn"
        class="chat-assistant-button"
        v-on:click="startChat"
      >
        START CHAT
      </button>
      <div class="chat" v-else>
        <div class="chat-container" ref="chatbox">
          <ul class="chat-box-list">
            <li class="bot">
              <p v-for="greeting in greetings" v-bind:key="greeting.index">
                <span> {{ greeting }} </span>
              </p>
            </li>
            <li
              class="message"
              v-for="(message, index) in messages"
              :key="index"
              :class="message.author"
            >
              <p>
                <span> {{ message.text }} </span>
              </p>
              <p>
                <span> {{ message.responseText }} </span>
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
              text: "Here's a sample Technical Interview Question: ",
              responseText: response.data.responseText,
              author: "bot",
            });
          }
        });
      } else if (msg.includes("behavioral")) {
        this.topic = "behavioral";
        AuthService.getPathwayDetails(this.topic).then((response) => {
          if (response.status === 200) {
            this.messages.push({
              text: "Here's a sample Behavioral Interview Question: ",
              responseText: response.data.responseText,
              author: "bot",
            });
          }
        });
      } else if (msg.includes("cover") || msg.includes("letter")) {
        this.topic = "cover";
        AuthService.getPathwayDetails(this.topic).then((response) => {
          if (response.status === 200) {
            this.messages.push({
              text: "Here's some information about Cover Letters: ",
              responseText: response.data.responseText,
              author: "bot",
            });
          }
        });
      } else if (
        msg.includes("attire") ||
        msg.includes("dress") ||
        msg.includes("business wear") ||
        msg.includes("cloth")
      ) {
        this.topic = "business wear";
        AuthService.getPathwayDetails(this.topic).then((response) => {
          if (response.status === 200) {
            this.messages.push({
              text: "Here's some information about Interview Attire: ",
              responseText: response.data.responseText,
              author: "bot",
            });
          }
        });
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
.logo {
  display: flex;
  flex-direction: row;
  width: 30%;
}

.logo h2 {
  font-family: "Poppins", sans-serif;
  font-size: 40px;
  color: antiquewhite;
  margin-top: 20px;
  margin-left: 3%;
}

.body-wrapper {
  display: flex;
  flex-direction: row;
  justify-content: space-around;
  height: 100vh;
}

.head-wrapper {
  display: flex;
  flex-direction: row;
  justify-content: space-around;
  width: 100%;
}

.chat {
  border: 1px solid gray;
  width: 60vw;
  height: 80vh;
  border-radius: 4px;
  background-color: white;
  width: 55%;
  height: 80%;
  margin-top: 3em;
}

.chat-container {
  width: 100%;
  height: 100%;
}

.chat-box-list {
  display: flex;
  flex-direction: column;
  list-style-type: none;
  overflow: scroll;
  height: 90%;
}

.chat-inputs {
  display: flex;
  flex-direction: row;
}

.chatinputbox {
  width: 100%;
  height: 50px;
  border: 1px solid gray;
  border-left: none;
  border-bottom: none;
  border-right: none;
  margin: 0;
  padding: 0;
  -webkit-box-sizing: border-box; /* Safari/Chrome, other WebKit */
  -moz-box-sizing: border-box; /* Firefox, other Gecko */
  box-sizing: border-box;
}

#welcome-message {
  text-transform: capitalize;
  font-family: "Poppins", sans-serif;
  font-size: 48px;
  color: antiquewhite;
  margin-left: 10px;
}

button {
  width: 180px;
  height: 50px;
  border: none;
  color: antiquewhite;
  background-color: #023e8a;
  font-family: "Poppins", sans-serif;
  font-size: 25px;
  letter-spacing: 4px;
  border-bottom-right-radius: 8px;
  outline: none;
  transition: ease-out 0.8s;
}

button:hover {
  background-color: #0076b6;
}

#nav > a {
  font-family: "Poppins", sans-serif;
  font-size: 35px;
  text-decoration: none;
  color: #caf0f8;
  margin-top: 25px;
  margin-bottom: 20px;
  padding: 8px 20px 5px 20px;
  background-color: #023e8a;
  border-radius: 8px;
  transition: ease-out 0.8s;
}

#nav > a:hover {
  text-decoration: underline;
  color: #0077b6;
}
#nav {
  display: flex;
  flex-direction: row;
  justify-content: space-around;
  width: 70%;
}

.chat-assistant-button {
  width: 300px;
  height: 80px;
  border-radius: 4px;
  margin-top: 2.3%;
}

.message.bot {
  float: left;
}

.message.client {
  float: right;
}
</style>

