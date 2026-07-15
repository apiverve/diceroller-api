declare module '@apiverve/diceroller' {
  export interface dicerollerOptions {
    api_key: string;
    secure?: boolean;
  }

  /**
   * Describes fields the current plan does not unlock. Locked fields arrive as null
   * in `data`; `locked_fields` names them, using dot paths for nested fields.
   * Absent when the plan unlocks everything.
   */
  export interface PremiumInfo {
    message: string;
    upgrade_url: string;
    locked_fields: string[];
  }

  export interface dicerollerResponse {
    status: string;
    error: string | null;
    data: DiceRollerData;
    code?: number;
    premium?: PremiumInfo;
  }


  interface DiceRollerData {
      diceNotation:       null | string;
      numDice:            number | null;
      numSides:           number | null;
      modifier:           number | null;
      rolls:              (number | null)[];
      total:              number | null;
      totalWithModifier:  number | null;
      minRoll:            number | null;
      maxRoll:            number | null;
      averageRoll:        number | null;
      theoreticalMin:     number | null;
      theoreticalMax:     number | null;
      theoreticalAverage: number | null;
      expression:         null | string;
  }

  export default class dicerollerWrapper {
    constructor(options: dicerollerOptions);

    execute(callback: (error: any, data: dicerollerResponse | null) => void): Promise<dicerollerResponse>;
    execute(query: Record<string, any>, callback: (error: any, data: dicerollerResponse | null) => void): Promise<dicerollerResponse>;
    execute(query?: Record<string, any>): Promise<dicerollerResponse>;
  }
}
