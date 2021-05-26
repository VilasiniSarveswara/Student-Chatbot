<template>
  <div id="app">
    <div id="nav">
      <router-link v-bind:to="{ name: 'home' }">Home</router-link>
      <router-link v-bind:to="{ name: 'pathway' }"> Pathway Help</router-link>

      <router-link v-bind:to="{ name: 'curriculum' }">
        Curriculum Help
      </router-link>

      <router-link v-bind:to="{ name: 'quotes' }">
        Motivational Quotes
      </router-link>

      <router-link v-bind:to="{ name: 'positions' }">
        Open Positions
      </router-link>

      <router-link
        v-bind:to="{ name: 'logout' }"
        v-if="$store.state.token != ''"
        >Logout</router-link
      >
    </div>
    <router-view />
  </div>
</template>

<style>
@import url("https://fonts.googleapis.com/css2?family=Oswald:wght@500&display=swap");
html {
  background-image: url(../src/Images/pexels-harrison-candlin-2441454.jpg);
  background-attachment: fixed;
}

#nav {
  display: flex;
  flex-direction: row;
  justify-content: space-around;
}

#nav > a {
  font-family: "Oswald", sans-serif;
  font-size: 20px;
  text-decoration: none;
  color: #caf0f8;
  background-image: linear-gradient(
    to right,
    rgb(79, 155, 231),
    rgba(111, 178, 245, 0.4)
  );
  padding-top: 5px;
  padding-bottom: 5px;
  padding-left: 20px;
  padding-right: 20px;
  border-radius: 3px;
}

#nav > a:hover {
  font-size: 20px;
  text-decoration: underline;
  color: #48cae4;
  background-image: linear-gradient(
    to right,
    rgba(111, 178, 245, 0.4),
    rgb(79, 155, 231)
  );
}
h1 {
  color: #caf0f8;
  margin-left: 3.5%;
  font-family: "Oswald", sans-serif;
  font-size: 48px;
}
</style>
