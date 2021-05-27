<template>
  <div id="app">
    <router-view />
  </div>
</template>

<style>
/*@import url("https://fonts.googleapis.com/css2?family=Oswald:wght@500&family=Open+Sans&family=Oswald:wght@500&family=Poppins&family=Rubik&family=Spartan&display=swap");
html {
  background-image: url(../src/Images/pexels-harrison-candlin-2441454.jpg);
  background-attachment: fixed;
}*/

#nav {
  display: flex;
  flex-direction: row;
  justify-content: space-around;
  margin-top: 1%;
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
  font-size: 60px;
  font-family: "Open Sans", sans-serif;
  margin-bottom: 0%;
  margin-top: 3.5%;
  margin-left: 3%;
  letter-spacing: 3px;
  color: #caf0f8;
}
h2 {
  font-size: 60px;
  font-family: "Open Sans", sans-serif;
  margin-bottom: 0%;
  margin-top: 3.5%;
  margin-left: 3%;
  letter-spacing: 3px;
  color: #caf0f8;
}
</style>
