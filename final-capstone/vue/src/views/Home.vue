<template>
  <div class="home">
    <h1>Home</h1>
    <button>My Account</button>
    <p>Welcome, {{ this.$store.state.user_details.firstName }} Student</p>
  </div>
</template>

<script>
export default {
  name: "home",
};
</script>

<style scoped>
h1 {
  color: white;
  margin-left: 2%;
  font-family: "Oswald", sans-serif;
}

p {
  color: aqua;
  font-family: Arial, Helvetica, sans-serif;
  font-size: 72px;
}
</style>

