<template>
  <div>
    <h1>Events</h1>
    <ul>
      <li v-for="event in events" :key="event.id">
        {{ event.name }}
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
  },
};
</script>