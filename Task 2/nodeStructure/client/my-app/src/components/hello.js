import React from 'react'
import {useEffect , useState} from 'react'
import Table from 'react-bootstrap/Table'
import 'bootstrap/dist/css/bootstrap.min.css'
export const Hello = ()=> {
    const [initialState, setIntialState] = useState([])

    useEffect(() => {
        fetch('/api/').then(res => {
            if(res.ok){
                return res.json()
            }
        }).then(jsonResponse => setIntialState(jsonResponse.hello))
    },[])

    console.log(initialState)
    return(  <div>
        <h2>Employees List</h2>
        <br></br>
        <div>

        <Table striped bordered hover>
        <thead>
            <tr>
               <th> First Name </th>
               <th> Last Name </th>
               <th> User ID</th>
               <th> Job Title</th>
               <th> Department </th>
               <th> Mobile </th>
               <th> E-mail </th>
            </tr>
        </thead>
        <tbody>
        {
          initialState.map(
          (employee,i) => 
          <tr key={i}>
            <td> {employee.firstName} </td>   
            <td> {employee.lastName}</td>
            <td>{employee.userId}</td>
            <td> {employee.jobTitleName} </td>   
            <td> {employee.department}</td>
            <td>{employee.phoneNumber}</td>
            <td>{employee.emailAddress}</td>
          </tr>
          )
        }
        </tbody>
        </Table>
      </div>
      </div>)
}