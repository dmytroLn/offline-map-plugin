import { registerPlugin } from '@capacitor/core';

import type { OfflineMapPlugin } from './definitions';

const OfflineMap = registerPlugin<OfflineMapPlugin>('OfflineMap', {
  web: () => import('./web').then(m => new m.OfflineMapWeb()),
});

export * from './definitions';
export { OfflineMap };
