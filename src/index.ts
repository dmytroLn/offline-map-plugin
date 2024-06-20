import { registerPlugin } from '@capacitor/core';

import type { OfflineMapPlugin } from './definitions';

const OfflineMap = registerPlugin<OfflineMapPlugin>('OfflineMap', {
  web: () => import('./web').then(m => new m.OfflineMapWeb()),
  // android: () => import('./android').then(m => new m.MapboxPlugin()), // Create `android.ts` to load `MapboxPlugin`
});

export * from './definitions';
export { OfflineMap };
