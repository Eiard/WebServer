let employee_in = document.getElementById('in');
let employee_out = document.getElementById('out');
let table_in = document.getElementById('table-in');
let table_out = document.getElementById('table-out');

table_out.style.display = 'none';

employee_in.addEventListener('click', () => {
    table_in.style.display = 'block';
    table_out.style.display = 'none';
})


employee_out.addEventListener('click', () => {
    table_out.style.display = 'block';
    table_in.style.display = 'none';
})
