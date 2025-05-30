/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bmi_ant;

/**
 *
 * @author JOHN FREDIERICK MORA
 */
public class Normal_routine extends Routine{
    String Nroutine =  
"🎉 YOUR BMI IS NORMAL!\n\n" +

"🔍 **Step 1: Define Your Goal**\n" +
"Which of these best describes what you want?\n" +
"• ✅ Maintain current weight & improve overall fitness\n" +
"• 💪 Build muscle and strength\n" +
"• 🏃 Improve cardiovascular endurance or athletic performance\n" +
"• 🧘‍♀️ Enhance flexibility, mobility, and stress relief\n" +
"• 🧼 Tone up / improve body composition\n\n" +

"📋 **Step 2: Sample Routine for Each Goal**\n\n" +

"✅ **1. General Fitness (Maintenance)**\n" +
"• Routine: 3–5x/week mixed training\n" +
"    - 2x Strength (Full-body workouts)\n" +
"    - 2x Cardio (Jog, bike, swim, or HIIT)\n" +
"    - 1x Mobility/Yoga\n" +
"• Goal: Balanced health, energy, and fitness\n\n" +

"💪 **2. Muscle Building**\n" +
"• Routine: 4–5x/week strength training\n" +
"    - Day 1: Push (Chest, Shoulders, Triceps)\n" +
"    - Day 2: Pull (Back, Biceps)\n" +
"    - Day 3: Legs\n" +
"    - Day 4: Rest or Active Recovery\n" +
"    - Day 5: Full Body or Repeat\n" +
"• Add: 1–2 short cardio sessions for heart health\n" +
"• Nutrition: Slight calorie surplus + high protein\n\n" +

"🏃 **3. Endurance / Cardio Focus**\n" +
"• Routine: 4–6x/week aerobic training\n" +
"    - 3–4x Running, Cycling, Rowing, Swimming\n" +
"    - 1–2x Strength (focus on core and legs)\n" +
"    - Optional: HIIT, Yoga, Stretching\n" +
"• Nutrition: Balanced diet with enough carbs for fuel\n\n" +

"🧘 **4. Mobility & Stress Relief**\n" +
"• Routine: 3–6x/week low-impact training\n" +
"    - 3x Yoga/Pilates/Mobility work\n" +
"    - 2–3x Light strength or bodyweight exercises\n" +
"    - Daily walking & breathing exercises\n" +
"• Goal: Reduce tension, improve posture & joint health\n\n" +

"🧼 **5. Toning / Body Recomposition**\n" +
"• Routine: 4–5x/week\n" +
"    - 3x Strength Training\n" +
"    - 2x Cardio (HIIT or moderate intensity)\n" +
"    - Daily walking + occasional yoga/stretching\n" +
"• Nutrition: Slight calorie deficit, high protein\n\n" +

"🧠 **Tips for All Goals**\n" +
"• Warm up before every workout (5–10 mins)\n" +
"• Stretch or foam roll after\n" +
"• Prioritize sleep (7–9 hrs)\n" +
"• Stay hydrated & eat whole, nutrient-dense foods\n";


    @Override
    public String Message(String routine) {
        return Nroutine;
    }
    
    
    
}
