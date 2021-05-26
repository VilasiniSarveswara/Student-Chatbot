<template>
  <div class="home">
    <div id="heading-wrapper">
      <h2 id="welcome-message">
        Welcome, {{ this.$store.state.user_details.firstName }}
      </h2>
      <h4>Current Student</h4>
    </div>
    <button>My Account</button>
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
h4 {
  font-size: 48px;
  color: #caf0f8;
  margin-left: 3%;
  margin-bottom: 0.5%;
  font-family: "Oswald", sans-serif;
}
h2 {
  font-size: 60px;
  font-family: "Oswald", sans-serif;
  margin-bottom: 0%;
}

#welcome-message {
  text-transform: capitalize;
}

button {
  margin-left: 3.5%;
  background-color: beige;
  font-size: 14px;
}
</style>

