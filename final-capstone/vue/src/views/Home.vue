<template>
  <div class="home">
    <div id="heading-wrapper">
      <h2 id="welcome-message">
        Welcome, {{ this.$store.state.user_details.firstName }}!
      </h2>
      <h6 v-if="this.$store.state.user_details.student">Student</h6>
      <h6 v-else>Alumni</h6>
    </div>
    <article class="description">
      <p>
        The Tech Elevator Chatbot is here to help! Click above to any of our
        categories, type in what you need help with, and get help with
        everything you need!
      </p>
    </article>
  </div>
</template>

<script>
export default {
  name: "home",
};
</script>

<style scoped>
/*#heading-wrapper {
  color: #caf0f8;
  font-family: Arial, Helvetica, sans-serif;
  font-size: 60px;
  margin-left: 15%;
  background-image: linear-gradient(
    to bottom right,
    #023e8a,
    #0077b6,
    #0096c7,
    #0077b6,
    #023e8a
  );
  background-clip: padding-box;
  padding: 10px;
  margin-right: 15%;
  text-align: center;
  border-radius: 7px;
} */
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

.description {
  margin: 15%;
  margin-top: 5%;
  padding: 25px;
  font-size: 32px;
  font-family: "Poppins", sans-serif;
  text-align: center;
  color: #caf0f8;
  background-image: linear-gradient(to bottom right, #023e8a, #0077b6, #023e8a);
  border-radius: 7px;
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

</style>

