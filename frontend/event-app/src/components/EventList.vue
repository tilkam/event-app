<template>
  <div>
    <h1>Events</h1>
    <ul>
      <li v-for="event in events" :key="event.id">
        {{ event.name }}
        <button @click="deleteEvent(event.id)">Delete</button>
      </li>
    </ul>
  </div>
</template>

<script>
import axios from 'axios';

export default {
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