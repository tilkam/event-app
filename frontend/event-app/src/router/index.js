import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      component: HomeView
    },
    {
      path: '/about',
      name: 'about',
      // route level code-splitting
      // this generates a separate chunk (About.[hash].js) for this route
      // which is lazy-loaded when the route is visited.
      component: () => import('../views/AboutView.vue')
    },
    {
      path: '/create',
      name: 'create',
      component: () => import('../views/CreateEventView.vue')
    },
    {
      path: '/event/all',
      name: 'events',
      component: () => import('../views/EventView.vue')
    },
    {
      path: '/event/:id',
        name: 'event',
        component: () => import('../views/EventDetailView.vue')
    },
    {
        path: '/event/edit/:id',
            name: 'edit',
            component: () => import('../views/EditEventView.vue')
    }
  ]
})

export default router
