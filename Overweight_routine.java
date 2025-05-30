/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bmi_ant;

/**
 *
 * @author JOHN FREDIERICK MORA
 */
public class Overweight_routine extends Routine{
    String Ovrout = "⚠️ YOU ARE OVERWEIGHT!\n\n" +

"💪 **1. Exercise Routine for Overweight**\n" +
"**Goal:** Burn calories, build strength, and improve endurance — safely and sustainably.\n\n" +

"🏃‍♂️ **Cardio (3–5x/week)**\n" +
"• Start with low-impact options: walking, cycling, swimming, or elliptical\n" +
"• Duration: 20–45 minutes per session\n" +
"• Gradually increase intensity or time as your fitness improves\n" +
"• Optional: Add HIIT (interval training) once you're comfortable for better fat burning\n\n" +

"🏋️ **Strength Training (2–3x/week)**\n" +
"• Focus on full-body workouts with compound movements:\n" +
"    - Squats, push-ups (on knees if needed), rows, lunges, planks\n" +
"• Use bodyweight or light weights/resistance bands\n" +
"• Purpose: Build muscle to boost metabolism and support fat loss\n\n" +

"🤸 **Flexibility & Mobility (Daily or every other day)**\n" +
"• Gentle stretching or yoga\n" +
"• Improves joint health and helps prevent injury\n\n" +

"🥗 **2. Nutrition for Fat Loss**\n" +
"• Aim for a slight calorie deficit (reduce 300–500 kcal/day)\n" +
"• Focus on whole foods:\n" +
"    - Vegetables, lean protein, whole grains, healthy fats\n" +
"• Limit processed foods, sugary drinks, and excessive snacking\n" +
"• Eat smaller, more frequent meals to control hunger\n" +
"• Stay hydrated: drink plenty of water\n\n" +

"😴 **3. Lifestyle & Recovery**\n" +
"• Sleep: Prioritize 7–9 hours per night — essential for fat loss\n" +
"• Stress: Manage it with meditation, hobbies, or light activity\n" +
"• Progress Tracking: Weigh-ins or measurements weekly (don’t obsess)\n\n" +

"🗓️ **Sample Weekly Routine (Beginner Friendly)**\n" +
"• **Monday:** 30 min brisk walk + full-body strength\n" +
"• **Tuesday:** Rest or light yoga/stretching\n" +
"• **Wednesday:** 30–40 min cycling or swimming\n" +
"• **Thursday:** Full-body strength training\n" +
"• **Friday:** Rest or easy walk\n" +
"• **Saturday:** 30 min interval walking/jogging\n" +
"• **Sunday:** Mobility work + stretching\n\n" +

"💡 **Bonus Tips**\n" +
"• Wear comfortable, supportive shoes and breathable clothes\n" +
"• Find a workout buddy or join a group for accountability\n" +
"• Celebrate non-scale victories: better mood, more energy, improved sleep\n";

    @Override
    public String Message(String routine) {
        return Ovrout;
    }
    
    
    
}
