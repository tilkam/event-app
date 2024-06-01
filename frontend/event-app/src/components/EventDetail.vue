
<template>
  <div class="wrapper-event">
    <div class="header-event-card"><h3>{{ name }}</h3></div>
    <div class="content-event-card">
      <p>{{ formatDate(startDate) }} - {{startTime}}</p>
      <div v-if="endDate">{{formatDate(endDate)}} - {{endTime}}</div>
      <p>{{ location }}</p>
      <p>{{ description }}</p>
    </div>
  </div>

</template>
<script setup>
import { defineProps, onMounted, ref } from 'vue';
import { useRoute } from 'vue-router';
import axios from 'axios';

const id = ref('');
const name = ref('');
const description = ref('');
const location = ref('');
const startDate = ref('');
const endDate = ref('');
const startTime = ref('');
const endTime = ref('');

defineProps(['id', 'name', 'description', 'location', 'startDate', 'endDate', 'startTime', 'endTime'])
const route = useRoute();

const formatDate = (dateString) => {
  const date = new Date(dateString);
  return `${date.getDate()}/${date.getMonth() + 1}`;
};

const fetchEvent = async () => {
  const response = await axios.get(`http://localhost:8080/event/${route.params.id}`);
  name.value = response.data.name;
  description.value = response.data.description;
  location.value = response.data.location;
  startDate.value = response.data.startDate;
  endDate.value = response.data.endDate;
  startTime.value = response.data.startTime;
  endTime.value = response.data.endTime;
};

onMounted(() => fetchEvent());
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
