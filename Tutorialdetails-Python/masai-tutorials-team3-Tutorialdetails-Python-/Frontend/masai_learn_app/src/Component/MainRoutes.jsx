import React from 'react'
import {Route, Routes} from 'react-router-dom'
import { Footer } from './Footer'
import { HomePage } from './HomePage'
export const MainRoutes = () => {
  return (
    <Routes>
        <Route path='/' element={<HomePage/>} />
        <Route path='/footer' element={<Footer/>} />
        {/* <Route path={} elemant={} /> */}
        {/* <Route path={} elemant={} /> */}
        {/* <Route path={} elemant={} /> */}
    </Routes>
  )
}
