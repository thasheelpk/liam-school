import uuid from 'uuid/v1';

export default [
  {
    id: uuid(),
    page: 'Courses',
    amount: 30.5,
    action: {
      name: 'Course listed'
    },
    createdAt: 1555016400000,
    status: 'completed'
  }
];
