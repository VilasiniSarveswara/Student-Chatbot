<template>
  <div class="home">
    <h1>Home</h1>
    <button>My Account</button>
    <h2 id="welcome-message">
      Welcome, {{ this.$store.state.user_details.firstName }} Student
    </h2>
  </div>
</template>

<script>
export default {
  name: "home",
};
</script>

<style scoped>
h2 {
  color: #caf0f8;
  font-family: Arial, Helvetica, sans-serif;
  font-size: 60px;
  margin-left: 10%;
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
  margin-right: 10%;
  text-align: center;
  border-radius: 7px;
}

button {
  margin-left: 3.5%;
  background-color: beige;
  font-size: 14px;
}
</style>

