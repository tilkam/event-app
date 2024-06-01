
<template>
  <div class="wrapper-event">
    <div class="header-event-card"><h3>{{ name }}</h3></div>
    <div class="content-event-card">
      <p>{{ formatDate(startDate) }} - {{startTime}}</p>
      <p>{{ location }}</p>
      </div>
  </div>

</template>
<script setup>
import axios from "axios";

defineProps(['name', 'description', 'location', 'startDate', 'endDate', 'startTime', 'endTime'])
const formatDate = (dateString) => {
  const date = new Date(dateString);
  return `${date.getDate()}/${date.getMonth() + 1}`;
};
</script>

<style>
.wrapper-event {
  border: 1px solid #ccc;
  border-radius: .5rem;
  margin-bottom: .5rem;
  padding: .5rem;
  display: flex;
  flex-direction: column;
  overflow: hidden;
}
.content-event-card {
  margin-bottom: 1rem;

}
</style>