import { WebPlugin } from '@capacitor/core';

import type { OfflineMapPlugin } from './definitions';

export class OfflineMapWeb extends WebPlugin implements OfflineMapPlugin {
  async echo(options: { value: string }): Promise<{ value: string }> {
    console.log('ECHO', options);
    return options;
  }
}
