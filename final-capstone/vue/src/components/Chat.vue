<template>
  <div>
    <div class="chat">
      <div class="chat-container" ref="chatbox">
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
          <input type="text" v-model="message" @keyup.enter="sendMessage" />
          <button @click="sendMessage">Send</button>
        </div>
      </div>
    </div>
  </div>
  <!-- in Styling, float left and float right will have the messages displaying on either side, and using the dynamic class 
  messages can be put into different colors. with the sendMessage function we need to be able to send a request to the back end
  and we need to be able to get the response to put into our messages from the back end's answer.
  
  setting an overflow: scroll will keep the chatbox from distorting when there are more messages than the window can contain-->
</template>

<script>
export default {
  name: "Chat",
  data: () => ({
    message: "",
    messages: [],
  }),
  methods: {
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

<style>
</style>