<template>
  <div>
    <h1>Events</h1>
    <div class="wrapper-event-list">
      <div v-for="event in events" :key="event.id">
        <router-link :to="`/event/${event.id}`">
        <component
            :is="cardComponent"
          :name="event.name"
          :description="event.description"
          :location="event.location"
          :startDate="event.startDate"
          :endDate="event.endDate"
          :startTime="event.startTime"
          :endTime="event.endTime"/>
        </router-link>
        <button @click="deleteEvent(event.id)">Delete</button>
      </div>

  </div>
  </div>
</template>

<script>
import axios from 'axios';
import EventCard from "@/components/EventCard.vue";

export default {
  components: {
    EventCard,
  },
  props: ['cardComponent'],
  data() {
    return {
      events: [],

    };
  },

  mounted() {
    this.fetchEvents();
  },
  methods: {
    async fetchEvents() {
      const response = await axios.get('http://localhost:8080/event/all');
      this.events = response.data;
    },
    deleteEvent(id) {
      axios.delete(`http://localhost:8080/event/delete/${id}`).then(() => {
        this.fetchEvents();
      });
    },
  },
};
</script>
<style>
  .wrapper-event-list{
    margin: 0 auto;
    max-width: 800px;
    gap: 1rem;
  }

</style>