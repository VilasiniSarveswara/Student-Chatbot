<template>
  <div class="home">
    <div id="heading-wrapper">
      <h2 id="welcome-message">
        Welcome, {{ this.$store.state.user_details.firstName }}!
      </h2>
      <h6 v-if="this.$store.state.user_details.student">Student</h6>
      <h6 v-else>Alumni</h6>
    </div>
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
  margin: 0%;
  margin-left: 3%;
  font-family: "Oswald", sans-serif;
}
h2 {
  font-size: 60px;
  font-family: "Oswald", sans-serif;
  margin-bottom: 0%;
  margin-top: 3%;
  margin-left: 3%;
}

#welcome-message {
  text-transform: capitalize;
}
</style>

