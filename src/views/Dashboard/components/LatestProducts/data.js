import uuid from 'uuid/v1';
import moment from 'moment';

export default [
  {
    id: uuid(),
    name: 'Asset name',
    imageUrl: 'https://elparah.store/admin/upload/no_image.png',
    updatedAt: moment().subtract(2, 'hours')
  },
  {
    id: uuid(),
    name: 'Asset name',
    imageUrl: 'https://elparah.store/admin/upload/no_image.png',
    updatedAt: moment().subtract(2, 'hours')
  }
];
