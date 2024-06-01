
<template>
  <div class="wrapper-event-info">
    <div class="header-event-card.info"><h1>{{ name }}</h1></div>
    <div class="title-event-card-info">
      <div>
      <h3>{{ name }}</h3>
      <p>{{ location }}</p>
      </div>
      <div id="date-time-info">
      <h3>{{ formatDate(startDate) }} </h3>
      <h3 v-if="endDate">{{formatDate(endDate)}}</h3>
        <p> {{startTime}}</p> <p v-if="endTime"> - {{endTime}}</p>
      </div>
      </div>
    <div class="content-event-card-info">
      <p>{{ description }}</p>
    </div>
    <div class="footer-event-card-info">
     <button @click="deleteEvent()">Delete</button>
      <button @click="editEvent()">Edit</button>
  </div>
  </div>
</template>
<script setup>
import { defineProps, onMounted, ref } from 'vue';
import { useRoute } from 'vue-router';
import axios from 'axios';
import router from "@/router/index.js";

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
const deleteEvent = async () => {
  axios.delete(`http://localhost:8080/event/delete/${route.params.id}`).then(() => {
    router.push('/');
  });
};
const editEvent = async () => {
  await router.push(`/event/edit/${route.params.id}`);
};

onMounted(() => fetchEvent());
</script>

<style>
.wrapper-event-info {
  border: 1px solid #ccc;
  border-radius: .5rem;
  padding: .5rem;
  display: flex;
  flex-direction: column;
  overflow: hidden;
  margin: 1rem;
}
.content-event-card-info {
  margin-bottom: 1rem;
}
.title-event-card-info {
  display: grid;
  grid-template-columns: repeat(2, 1fr);
  grid-template-rows: repeat(2, 1fr);

}
#date-time-info {
  text-align: end;
}

</style>
