<template>
  <div class="about">
    <h1>This is an about page</h1>
    <p>
      This is a simple event app that allows users to create and view events.
  </div>
</template>


<style>
@media (min-width: 1024px) {
  .about {
    min-height: 100vh;
    display: flex;
    align-items: center;
  }
}
</style>
<script>
export default {
  name: "AboutView",
};
</script>